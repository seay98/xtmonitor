/**
 * 
 */
$(document).ready(function () {
	var sysid = $("#sysid").attr("value");
	var url = "../sysdevices/" + sysid;
	//var url = "/xtmon/resources/tdata.txt";
    // prepare the data
    var source =
    {
        datatype: "json",
        datafields: [
            { name: 'devicename', type: 'string' },
            { name: 'ipaddr', type: 'string' },
            { name: 'ident', type: 'string' },
            { name: 'devicetype', type: 'string' },
            { name: 'belongto', type: 'string' },
            { name: 'location', type: 'string' },
            { name: 'switcher', type: 'string' },
            { name: 'lmtime', type: 'string' },
            { name: 'savetime', type: 'string' },
            { name: 'state', type: 'string' },
            { name: 'status', type: 'string' },
            { name: 'alarm', type: 'string' }
        ],
        url: url
    };
    
    var dataAdapter = new $.jqx.dataAdapter(source, {
        downloadComplete: function (data, status, xhr) { },
        loadComplete: function (data) { },
        loadError: function (xhr, status, error) { }
    });
    
    var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties, rowdata) {
        if (value == "0") {
            return '<span style="margin: 4px; float: ' + columnproperties.cellsalign + '; color: #008000;">正常</span>';
        }
        else if (value == "1") {
            return '<span style="margin: 4px; float: ' + columnproperties.cellsalign + '; color: #ff0000;">告警</span>';
        }
        else {
            return '<span style="margin: 4px; float: ' + columnproperties.cellsalign + '; color: gray">离线</span>';
        }
    };
    
    var initrowdetails = function (index, parentElement, gridElement, datarecord) {
    	var alarm = null;
    	divs = $($(parentElement).children()[0])
    	if (divs != null) {
    		alarm = divs.find('.alarm');
    		var info = null;
    		var state = datarecord.state;
    		if (state == 0) {
    			info = $('<div style="white-space: normal; margin: 5px;"><span style="color: #008000;">' + datarecord.status + '</span></div>');
    		} else if (state ==1) {
    			info = $('<div style="white-space: normal; margin: 5px;"><span style="color: #ff0000;">' + datarecord.alarm + '</span></div>');
    		} else {
    			info = $('<div style="white-space: normal; margin: 5px;"><span style="color: gray">设备离线</span></div>');
    		}
        	$(alarm).append(info);
    	}
    };

    $("#devicelist").jqxGrid(
            {
                width: '100%',
                source: dataAdapter,
                autoheight: true,
                columnsresize: true,
                sortable: true,
                altrows: true,
                enabletooltips: true,
                editable: false,
                rowdetails: true,
                rowdetailstemplate: { rowdetails: "<div style='margin: 10px;'><div class='alarm'></div></div>", rowdetailsheight: 150 },
                initrowdetails: initrowdetails,
                columns: [
                  { text: '设备名称', columngroup: 'basicproperty', datafield: 'devicename' },
                  { text: 'IP地址', columngroup: 'basicproperty', datafield: 'ipaddr', width: 120 },
                  { text: '标识/端口', columngroup: 'basicproperty', datafield: 'ident', width: 120 },
                  { text: '设备位置', columngroup: 'basicproperty', datafield: 'location', width: 80 },
                  { text: '复用位置', columngroup: 'basicproperty', datafield: 'switcher', width: 80 },
                  { text: '类型', columngroup: 'basicproperty', datafield: 'devicetype', width: 60 },
                  { text: '所属系统', columngroup: 'basicproperty', datafield: 'belongto' },
                  { text: '修改时间', datafield: 'lmtime' },
                  { text: '创建时间', datafield: 'savetime' },
                  { text: '状态', datafield: 'state', cellsrenderer: cellsrenderer, width: 40 }
                ],
                columngroups: [
                    { text: '基本属性', align: 'center', name: 'basicproperty' }
                ]
            });

});