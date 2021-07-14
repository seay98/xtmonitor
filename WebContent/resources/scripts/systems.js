/**
 * home.jsp页面script
 */
$(document).ready(function () {
	updateData();
	
	setInterval(updateData, 5000);
	
});

function updateData() {
	//显示时间
	var now = new Date();
	var datetime = now.format("yyyy年MM月dd日 hh:mm:ss")
	$("#curtime").text(datetime);
	//背景颜色设置
	var backcolorok = "background-color: rgb(60, 180, 60);";
	var backcolorerr = "background-color: rgb(255, 55, 55);";
	var backcolorwarning = "background-color: rgb(60, 125, 10);";
	var backcoloroffline = "background-color: rgb(160, 160, 160);";
	
	//图片设置
	var imgok = "/xtmon/resources/images/sys_ok.png";
	var imgerr = "/xtmon/resources/images/sys_err.png";
	var imgoffline = "/xtmon/resources/images/sys_offline.png"
		
	$.getJSON("sysstatus", function(data){
		for (var i in data) {
			//alert(data[i]);
			var sys = data[i];
			var id = sys.id;
			var status = sys.status;
			
			//设置图片
			var metroid = "#metro-" + id;
			var imgid = "#sys-img-" + id;
			var statusid = "#sys-status-" + id;
			var timeid = "#sys-time-" + id;

			//获得当前状态
			var statustext = $(statusid).text();
			var curstatus = -2;
			if (statustext == "正常") {
				curstatus = 0;
			} else if (statustext == "告警") {
				curstatus = 1;
			} else if (statustext == "未连接") {
				curstatus = -1;
			}
			
			//如果状态改变，则更新。否则只更新时间
			if (curstatus != status) {
				if (status == "0") {
					$(imgid).attr("src", imgok);
					$(metroid).attr("style", backcolorok);
					$(statusid).text("正常");
				} else if (status == "1") {
					$(imgid).attr("src", imgerr);
					$(metroid).attr("style", backcolorwarning);
					$(statusid).text("告警");
				} else if (status == "-1") {
					$(imgid).attr("src", imgoffline);
					$(metroid).attr("style", backcoloroffline);
					$(statusid).text("未连接");
				}
			}

			$(timeid).text(sys.time);
		}
	});
}