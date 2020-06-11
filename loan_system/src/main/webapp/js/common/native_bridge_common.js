/**
 * 新网络请求区别于旧网络请求的差别是非0的返回就不直接调用successfn函数 而是框架层根据返回码不同直接处理，
 * 如果遇到特殊的业务需要遇到非0返回调用业务的情况，则在extendfn字段写入而外的回调方法
 * 
 * url 相对路径
 * successfn 正确回调方法名
 * errorfn 错误回调方法名
 * extendfn  而外回调方法名
 * distributefn 同一分发方法
 * parms 就是参数
 * needMask 是否需要遮罩  true false
 * 
 * json形参 网络请求
 * 
 * @param {Object}
 *            url
 * @param {Object}
 *            data
 * @param {Object}
 *            successfn
 * @param {Object}
 *            errorfn
 */
function commonPostDataJson(jsonstr) {
	var jsonObj = jQuery.parseJSON(jsonstr);
	var fnSuce = window[jsonObj.successfn];
	var fnErro = window[jsonObj.errorfn];
	var extendfn = window[jsonObj.extendfn];

	if(!jsonObj.async || jsonObj.async ==""){
		jsonObj.async = true;
	}
	if(jsonObj.needMask==null||jsonObj.needMask==true){
		showDialog();
	}
	var csrf_token = uuid();
	setCookie("csrf_token", csrf_token);
	$.ajax({
		url: jsonObj.url,
		type: "post",
		async: jsonObj.async,
		data: {
			'data': JSON.stringify(jsonObj.parms),
			"csrf_token":csrf_token
		},
		dataType: "html",
		timeout: "30000",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			fnErro(XMLHttpRequest, textStatus, errorThrown);
		},
		success: function(data) {
			disDialog();
			var obj = jQuery.parseJSON(data);
			if(obj.code == "-8888"){
			 	alert("seesionKey超时");
			}else if(obj.code == 0)
			{
				fnSuce(data);
			}else if(jsonObj["extendfn"]!=undefined && jsonObj["extendfn"]!=null &&  jsonObj["extendfn"]!='') { // 说明业务要返回
				extendfn(data);
			}else if(obj.code != 0) {
				if("log" == jsonObj.type){
					return;
				}
				alert("业务参数有误"+obj.code+"  "+jsonObj.url);
			}
		}
	});
}


/**
 * 显示进度框
 */
function showDialog() {
	if ($("#common_loding").length > 0) {
		$("#common_loding").show();
		return;
	}
	var html = '<div id="common_loding"style="height: 100%; width: 100%; z-index: 2000;position: fixed;">';
	html += '<img  src="../../css/loading.gif" style="	position: absolute; width: 20%;    left: 40%;top: 40%;z-index: 2001""/>';
	var htmlbg = '<div style="height: 100%; width: 100%; background-color: #222222; position: fixed; top: 0px; left: 0px; opacity:0.7; z-index: 9999998">';
	html += '</div>';
	$("body").prepend(html);
}

function disDialog() {
	$("#common_loding").hide();
}
/**
 * 设置cookie
 * @param name
 * @param value
 */
function setCookie(name,value){ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + 3*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";path=/;expires=" + exp.toGMTString(); 
}
function delCookie(name) { 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getcookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 

/**
 * 读取cookie
 * @param name
 * @returns
 */

function getcookie(objname){//获取指定名称的cookie的值
	var arrstr = document.cookie.split("; ");
	for(var i = 0;i < arrstr.length;i ++){
		var temp = arrstr[i].split("=");
		if(temp[0] == objname) return unescape(temp[1]);
	}
}

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }

    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";
    
    var uuid = s.join("");
    return uuid;

}	
