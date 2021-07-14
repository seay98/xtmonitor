/**
 * files.jsp页面脚本
 */
//饼图数据源
var srcchart = {
        datatype: "json",
        datafields: [
            { name: 'system' },
            { name: 'count' }
        ],
        url: 'filestoday'
};
var adaptchart =  new $.jqx.dataAdapter(srcchart, {
	async: false,
	autoBind: false,
	loadError: function (xhr, status, error) { alert('Error loading "' + source.url + '" : ' + error); } 
});

//表格数据源
var srcgrid = {
		datatype: "json",
		datafields: [
			{name: 'system', type: 'string'},
			{name: 'count', type: 'int'},
			{name: 'lmtime', type: 'string'},
			{name: 'span', type: 'int'}
		],
		url: ''
};
var adaptgrid = new $.jqx.dataAdapter(srcgrid, {
	async: false,
	autoBind: false,
	loadError: function (xhr, status, error) { alert('Error loading "' + source.url + '" : ' + error); } 
});

//线图数据源
var srcline = {
		datatype: "csv",
		datafields: [{
			name: 'datetime'},
			{name: 'today'},
			{name: 'yestoday'
		}],
		url: 'filesallcount'
};
var adaptline = new $.jqx.dataAdapter(srcline, {
	async: false,
	autoBind: false,
	loadError: function (xhr, status, error) { alert('Error loading "' + source.url + '" : ' + error); } 
});


$(document).ready(function () {
	//显示时间
	var now = new Date();
	var datetime = now.format("yyyy年MM月dd日 hh:mm:ss")
	$("#curtime").text(datetime);
	
	greatChart();
	
	srcgrid.url = "filesgrid";
	greatGrid();
	
	greatLine();
	
	//updateData();
	
	setInterval(updateData, 1000*60);
});

function updateData() {
	//显示时间
	var now = new Date();
	var datetime = now.format("yyyy年MM月dd日 hh:mm:ss")
	$("#curtime").text(datetime);
	
	adaptchart.dataBind();
	
	adaptgrid.dataBind();
	
	adaptline.dataBind();
}

function greatLine() {
	$("#filesline").jqxChart({
		title: "报量对比",
        description: "",
        enableAnimations: true,
        showLegend: true,
        showBorderLine: false,
        padding: { left: 10, top: 5, right: 10, bottom: 5 },
        titlePadding: { left: 0, top: 0, right: 0, bottom: 10 },
        source: adaptline,
        xAxis:
        {
            dataField: 'datetime',
            
            type: 'default',
            baseUnit: 'hour',
            showTickMarks: true,
            tickMarksInterval: 1,
            tickMarksColor: '#888888',
            unitInterval: 1,
            showGridLines: true,
            gridLinesInterval: 3,
            gridLinesColor: '#888888',
            valuesOnTicks: true,
            minValue: '0',
            maxValue: '24',
            textRotationAngle: -45,
            textRotationPoint: 'topright',
            textOffset: {x: 0, y: 0}
            
        },
        colorScheme: 'scheme04',
        seriesGroups:
            [
                {
                    type: 'line',
                    valueAxis:
                    {
                        unitInterval: 500,
                        minValue: 0,
                        maxValue: 4000,
                        displayValueAxis: true,
                        description: '24小时总报量情况',
                        axisSize: 'auto',
                        tickMarksColor: '#888888'
                    },
                    series: [
                            { dataField: 'today', displayText: '今日报量' },
                            { dataField: 'yestoday', displayText: '上周同日报量' }
                        ]
                }
            ]

	});
};

function greatGrid() {
	$("#filesgrid").jqxGrid({
		width: 600,
		height: 200,
    	columnsresize: true,
		source: adaptgrid,
		columns: [
			{text: "系统/线路名称", datafield: "system", width: 270},
			{text: "今日报量", datafield: "count", width: 75},
			{text: "最后传报时间", datafield: "lmtime", width: 180},
			{text: "未传报时间间隔", datafield: "span"}
		]
	});
};

function greatChart() {
    // prepare jqxChart settings
    var settings = {
        title: "实时报文传输监控",
        description: "(在控系统及其当日报量)",
        enableAnimations: true,
        showLegend: true,
        showBorderLine: false,
        legendLayout: { left: 10, top: 160, width: 300, height: 200, flow: 'vertical' },
        padding: { left: 5, top: 5, right: 5, bottom: 5 },
        titlePadding: { left: 0, top: 10, right: 0, bottom: 10 },
        source: adaptchart,
        colorScheme: 'scheme00',
        seriesGroups:
            [
                {
                    type: 'pie',
                    showLabels: true,
                    series:
                        [
                            { 
                                dataField: 'count',
                                displayText: 'system',
                                labelRadius: 170,
                                initialAngle: 15,
                                radius: 145,
                                centerOffset: 0,
                                formatFunction: function (value) {
                                    if (isNaN(value))
                                        return value;
                                    return parseFloat(value) + "份";
                                },
                            }
                        ]
                }
            ]
    };

    // setup the chart
    $('#fileschart').jqxChart(settings);
};