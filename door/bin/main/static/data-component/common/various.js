function jqgridPagerIcons() {
    var replace =
        {
            'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replace) icon.attr('class', 'ui-icon '+replace[$class]);
    })
}

function phoneFomatter(num,type){
	var formatNum = '';
	if(num.length===11){
		if(type==0){
			formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-****-$3');
		}else{
			formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
		}
	}else if(num.length==8){
		formatNum = num.replace(/(\d{4})(\d{4})/, '$1-$2');
	}else{
		if(num.indexOf('02')===0){
			if(num.length===10){
				if(type===0){
					formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-****-$3');
				}else{
					formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
				}
			}else if(num.length===9){
				if(type===0){
					formatNum = num.replace(/(\d{2})(\d{3})(\d{4})/, '$1-****-$3');
				}else{
					formatNum = num.replace(/(\d{2})(\d{3})(\d{4})/, '$1-$2-$3');
				}
			}

		}else{
			if(type==0){
				formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-***-$3');
			}else{
				formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
			}
		}
	}
	return formatNum;
}

function formmatterDate(cellValue) { // 날짜 필터
	   if (cellValue == null || cellValue === ''){
	       return '';
	   } else {
	    var y = cellValue.substring(0,4);
	    var m = cellValue.substring(4,6);
	    var d = cellValue.substring(6,8);
	    var h = cellValue.substring(8,10);
	    var mm = cellValue.substring(10,12);
	    var s = cellValue.substring(12,14);
	    var date = y+"-"+m+"-"+d+" "+h+":"+mm+":"+s;
	    return date;
	   }
}

function formmatterDate2(cellValue) { // 날짜 필터
	if (cellValue == null || cellValue === '' ){
		return '';
	} if(cellValue === '소계'){
		return cellValue;
	} else {
		cellValue = cellValue.replace(/[^0-9]/g,'');
		var y = cellValue.substring(0,4);
		var m = cellValue.substring(4,6);
		var d = cellValue.substring(6,8);
		var date = y+"-"+m+"-"+d
		return date;
	}
}

function formatterDate3(cellValue) { // 날짜 필터
	if (cellValue == null){
		return '';
	} else {

		return cellValue+'일';
	}
}

function formatterDate4(cellValue) { // 날짜 필터
	if (cellValue == null){
		return '';
	} else {
		var y = cellValue.substring(0,4);
		var m = cellValue.substring(4,6);
		var date = y+"-"+m+"월"
		return date;
	}
}

function formatter_check(cellValue) { // 날짜 필터
	if (cellValue === '' || typeof cellValue === "undefined"){
		return 'N';
	}
	return cellValue;
}


function jqGridResize(main_name, top_name) {
	$(window).on('resize', function () {
		$(main_name).setGridWidth($(top_name).width(), true);
	}).trigger('resize');
}
function jqGridResize2(main_name, top_name) {

		$(main_name).setGridWidth($(top_name).width(), true);

}


function modal_reset(class_name,readonly) {
	$(class_name).each(function(i){
		for (var i = 0; i < readonly.length; i++) {
			if (readonly[i] ===$(this).attr("name") ) {
				$(this).removeAttr("readonly");
			}
		}
		$(this).val("").trigger('change');
		if ($(this).hasClass("ynCheck") === true) {
			$(this).val("Y").trigger('change');
		}
	});
}


function modal_text_reset(class_name) {
	$(class_name).each(function(i){
		$(class_name).text("");
	});
}


function value_return(class_name) {
	var modal_objact = {};
	var objectName = null;
	var objectValue = null;
	$(class_name).each(function(i){
		objectName = $(this).attr("name");
		objectValue = $(this).val();
		modal_objact[objectName] = objectValue;
	});
		return modal_objact

}

// 조회기간같은 날짜 선택값 리턴 받을때 받은 값이 '-'를 포함해서
// -를 제거한 숫자만 넣어주기 위하여 사용
function value_return2(class_name) {
	var modal_objact = {};
	var objectName = null;
	var objectValue = null;
	$(class_name).each(function(i){
		objectName = $(this).attr("name");
		objectValue = $(this).val().replace(/-/gi,"");
		modal_objact[objectName] = objectValue;
	});
	return modal_objact

}

function modal_edits(class_name,readonly,data) {
	$(class_name).each(function(i){
		for (var i = 0; i < readonly.length; i++) {
			if (readonly[i] ===$(this).attr("name") ) {
				$(this).attr("readonly","readonly");
			}
		}
		$(this).val(data[$(this).attr("name")]).trigger('change');

	});
}



function select_makes(tag,url,value,text) {
	ccn_ajax(url,null).then(function (data) {
		var option = null
		for (var j = 0; j < data.length; j++) {
			option = $("<option></option>").text(data[j][text]).val(data[j][value]);
			$(tag).append(option);
		}
		$(tag).select2();
	}).catch(function (err) {
		console.error(err); // Error 출력
	});
}

function select_data_makes(tag,url,value,text,data) {
	ccn_ajax(url,data).then(function (data) {
		var option = null
		for (var j = 0; j < data.length; j++) {
			option = $("<option></option>").text(data[j][text]).val(data[j][value]);
			$(tag).append(option);
		}
		$(tag).select2();
	}).catch(function (err) {
		console.error(err); // Error 출력
	});
}

function select_data_makes2(tag,url,value,text,data) {
	return new Promise(function (resolve, reject) {
		$(tag).empty();
		ccn_ajax(url, data).then(function (data) {
			var option = null
			for (var j = 0; j < data.length; j++) {
				option = $("<option></option>").text(data[j][text]).val(data[j][value]);
				$(tag).append(option);
			}
			$(tag).select2();
			resolve(data);
		}).catch(function (err) {
			console.error(err); // Error 출력
		});
	});
}

function select_makes2(tag,url,value,text) {
	return new Promise(function (resolve, reject) {
		ccn_ajax(url, null).then(function (data) {
			var option = null
			for (var j = 0; j < data.length; j++) {
				option = $("<option></option>").text(data[j][text]).val(data[j][value]);
				$(tag).append(option);
			}
			$(tag).select2();
			resolve(data[0][value]);
		}).catch(function (err) {
			console.error(err); // Error 출력
		});
	});
}

function select_makes3(tag,url,value,text,data) {
	$(tag).empty();
	return new Promise(function (resolve, reject) {
		ccn_ajax(url, data).then(function (data2) {
			var option = null
			for (var j = 0; j < data2.length; j++) {
				option = $("<option></option>").text(data2[j][text]).val(data2[j][value]);
				$(tag).append(option);
			}
			$(tag).select2();
			resolve(data2[0][value]);
		}).catch(function (err) {
			console.error(err); // Error 출력
		});
	});
}

function select_makes_sub(tag,url,value,text,data,what) {
	$(tag).empty();
	if (what === "Y"){
		$(tag).append($("<option></option>").text("전체").val(""));
	}else if (what === 'N'){
		$(tag).append($("<option></option>").text("선택안함").val(""));
	}
	ccn_ajax(url,data).then(function (data) {
		var option = null
		for (var j = 0; j < data.length; j++) {
			option = $("<option></option>").text(data[j][text]).val(data[j][value]);
			$(tag).append(option);
		}
		$(tag).select2();
	}).catch(function (err) {
		console.error(err); // Error 출력
	});
}

function select_makes_sub_ajax(tag,url,value,text,data){
	return new Promise(function (resolve, reject) {
		$(tag).empty();
		$.ajax({
			url: url,
			type: 'POST',
			async: true,
			dataType: "json",
			data:data,
			success: function (data2) {
				var option = null
				for (var j = 0; j < data2.length; j++) {
					option = $("<option></option>").text(data2[j][text]).val(data2[j][value]);
					$(tag).append(option);
				}
				$(tag).select2();
				resolve("성공");
			},
			error: function () {
				reject(new Error("Request is failed"));
			}
		});
	});
}

function select_makes_sub_ajax2(tag,url,value,text,data,what){
	return new Promise(function (resolve, reject) {
		$(tag).empty();
		if (what === "Y"){
			$(tag).append($("<option></option>").text("전체").val(""));
		}else if (what === 'N'){
			$(tag).append($("<option></option>").text("선택안함").val(""));
		}
		$.ajax({
			url: url,
			type: 'POST',
			async: true,
			dataType: "json",
			data:data,
			success: function (data2) {
				var option = null
				for (var j = 0; j < data2.length; j++) {
					option = $("<option></option>").text(data2[j][text]).val(data2[j][value]);
					$(tag).append(option);
				}
				$(tag).select2();
				resolve("성공");
			},
			error: function () {
				reject(new Error("Request is failed"));
			}
		});
	});
}

function ccn_ajax(url,data){
	return new Promise(function (resolve, reject) {
		$.ajax({
	        url: url,
	        type: 'POST',
	        async: true,
	        dataType: "json",
	        data:data,
	        success: function (data2) {
	        	resolve(data2);
	        },
	        error: function () {
	        	reject(new Error("Request is failed"));
            }
	    });
	  });
}
function select_ajax(url,data){
	return new Promise(function (resolve, reject) {
		$.ajax({
			url: url,
			type: 'POST',
			async: true,
			dataType: "json",
			data:data,
			success: function (data2) {
				resolve(data2);
			},
			error: function () {
				reject(new Error("Request is failed"));
			}
		});
	});
}


function part_type_select_ajax(tag,url,value,text,data){
	return new Promise(function (resolve, reject) {
		$(tag).empty();
		$.ajax({
			url: url,
			type: 'POST',
			async: true,
			dataType: "json",
			data:data,
			success: function (data2) {
				var option = null
				for (var j = 0; j < data2.length; j++) {
					option = $("<option></option>").text(data2[j][text]).val(data2[j][value]);
					$(tag).append(option);
				}
				$(tag).select2();
				resolve(data2);
			},
			error: function () {
				reject(new Error("Request is failed"));
			}
		});
	});
}

function part_type_select_ajax_all(tag,url,value,text,data){
	return new Promise(function (resolve, reject) {
		$(tag).empty();
		$.ajax({
			url: url,
			type: 'POST',
			async: true,
			dataType: "json",
			data:data,
			success: function (data2) {
				var option = null;
				option = $("<option></option>").text('전체').val('');
				$(tag).append(option);
				for (var j = 0; j < data2.length; j++) {
					option = $("<option></option>").text(data2[j][text]).val(data2[j][value]);
					$(tag).append(option);
				}
				$(tag).select2();
				resolve(data2);
			},
			error: function () {
				reject(new Error("Request is failed"));
			}
		});
	});
}


function datepicker_makes(tag,num) {
	var date = new Date();
	date.setDate(date.getDate() + num);

    $( tag ).datepicker({
        autoclose: true,
        format:'yyyy-mm-dd',
        language: "kr",
		todayHighlight: true,
    }).datepicker('setDate',date);
}

function datepicker_makes1(tag,num) {
	var date = new Date();
	date.setDate(date.getDate() + num);

	$( tag ).datepicker({
		autoclose: true,
		format:'yyyy-mm-dd',
		language: "kr",
		startDate:date,
		todayHighlight: true,
	}).datepicker('setDate',date);
}



function modalValuePush(name1,name2,name3) {

		$(name2).val($(name1).val());
		if ($(name1).val() === ""){
			$(name3).val("");

		} else {

			$(name3).val($(name1 + " option:selected").text().trim());
		}


}

function callback(cb) {
	return  cb();
}


var findArrayIndex = function (array, predicateFunction) {
	var length = array == null ? 0 : array.length;
	if (!length) {
		return -1;
	}
	var index = -1;
	for (var i = 0; i < array.length; ++i) {
		if(predicateFunction(array[i])) {
			index = i;
			break;
		}
	}
	return index;
}



function comma(num){
	if (typeof num !== "undefined" && !isNaN(num) && num !== ''){
		var len, point, str;
		num = parseFloat(num).toFixed(2);
		num = num.toString();
		if(num.indexOf('.') != -1){
			var numSplit = num.toString().split('.');
			var numInt = numSplit[0]+"";
			point = numInt.length % 3 ;
			len = numInt.length;

			str = numInt.substring(0, point);
			while (point < len) {
				if (str != "") str += ",";
				str += numInt.substring(point, point + 3);
				point += 3;
			}
			str = str+"."+numSplit[1];
			return str;
		}else {
			num = num + "";
			point = num.length % 3 ;
			len = num.length;

			str = num.substring(0, point);
			while (point < len) {
				if (str != "") str += ",";
				str += num.substring(point, point + 3);
				point += 3;
			}

			return str;
		}
	} else {
		if (typeof num !== "undefined") {
			return num;

		}else {
			return '';
		}
	}
}

function comma2(num){
	var len, point, str;
	num = num + "";
	point = num.length % 3 ;
	len = num.length;

	str = num.substring(0, point);
	while (point < len) {
		if (str != "") str += ",";
		str += num.substring(point, point + 3);
		point += 3;
	}

	return str;
}



function num_keyup(e) {
	$(e).val($(e).val().replace(/[^0-9]/g,''));
}
function num_keyup_under(e) {
	$(e).val($(e).val().replace(/[^0-9:\-]/g,''));
}


function num_keyup_float(e) {
	$(e).val($(e).val().replace(/[^\.0-9]/g,''));
}


function ToFloat(number){

	var tmp = number + "";

	if(tmp.indexOf(".") != -1){

		number = parseFloat(number).toFixed(2);

		number = number.replace(/(0+$)/, "");

	}

	return number;

}
function parseFloat_change(number){

	var tmp = parseFloat(number);
	tmp = tmp.toFixed(2);
	tmp =parseFloat(tmp);
	return tmp;

}

function jqGrid_row_check(gridId,rowId) {
	$(gridId).jqGrid("setSelection", rowId);
}


function wrapWindowByMask2() {
    //화면의 높이와 너비를 구한다.
    var maskHeight = $(document).height();
    var maskHeight2 = maskHeight / 2;
//      var maskWidth = $(document).width();
    var maskWidth = window.document.body.clientWidth;
    var maskWidth2 = maskWidth / 2;

    var mask = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
    var loadingImg = '';

    loadingImg += "<div id='loadingImg' style='position:absolute; left:" + (maskWidth2 - 45) + "px;top:40%; display:none; z-index:10000;'>";
    loadingImg += " <img src='/ui-component/img/loading/loding1.gif' style='max-width: 50px; max-height: 50px;'/>";
    loadingImg += "</div>";

    //화면에 레이어 추가
    $('body')
        .append(mask)
        .append(loadingImg)

    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
    $('#mask').css({
        'width': maskWidth
        , 'height': maskHeight
        , 'opacity': '0.3'
    });

    //마스크 표시
    $('#mask').show();

    //로딩중 이미지 표시
    $('#loadingImg').show();
}

function closeWindowByMask() {
    $('#mask, #loadingImg').hide();
    $('#mask, #loadingImg').remove();
}