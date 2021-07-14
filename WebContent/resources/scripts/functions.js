/**
 * 常用的功能函数
 */
//对Date的扩展，将Date转化为制定格式的String
Date.prototype.format = function(fmt) {
	var o = {
			"M+" : this.getMonth() + 1,
			"d+" : this.getDate(),
			"h+" : this.getHours(),
			"m+" : this.getMinutes(),
			"s+" : this.getSeconds(),
			"q+" : Math.floor((this.getMonth()+3)/3),
			"S"  : this.getMilliseconds()
	};
	
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4-RegExp.$1.length));
	}
	
	for (var i in o) {
		if (new RegExp("("+i+")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, RegExp.$1.length==1?o[i]:("00"+o[i]).substr((""+o[i]).length));
		}
	}
	
	return fmt;
}