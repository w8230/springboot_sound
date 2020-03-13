////////////////////////////시작 함수/////////////////////////////////////
function modal_start1() {
    selectBox_modal1();

}


////////////////////////////클릭 함수/////////////////////////////////////
function addUdate_btn() {
    var modal_objact = value_return(".modal_value");
    if (effectiveness1(modal_objact)) {
        var text = '저장하겠습니까?';
        if (main_data.check === "U") {
            text = '수정하겠습니까?';
        }
        if (confirm(text)) {

            modal_objact.keyword = main_data.check;

            ccn_ajax("/sysUserAdd", modal_objact).then(function (data) {
                if (data.result === 'NG') {
                    alert(data.message);
                } else {
                    if (main_data.check === "I") {
                        get_btn(1);
                    } else {
                        get_btn_post($("#mes_grid").getGridParam('page'));
                    }
                }
                $("#addDialog").modal("hide");
            }).catch(function (err) {
                alert("저장실패");
            });
        }
    }

}

////////////////////////////호출 함수/////////////////////////////////////
function effectiveness1(modal_objact) { // 유효성 검사
    if (modal_objact.user_code === '') {
        alert("사용자코드를 입력해주세요");
        return false;
    } else if (modal_objact.user_name === '') {
        alert("사용자명을 입력해주세요");
        return false;
    } else if (modal_objact.dept_code === '') {
        alert("부서를 선택해주세요");
        return false;
    } else if (modal_objact.duty_code === '') {
        alert("직책을 선택해주세요");
        return false;
    } else if (modal_objact.auth_code === '') {
        alert("권한을 선택해주세요");
        return false;
    }  else {
        return true;
    }
}




function selectBox_modal1() {
    select_makes_sub("#dept_select2", "/sysDeptAllGet", "dept_code", "dept_name",{},'N');
    select_makes_sub("#duty_select", "/sysCommonAllGet", "code_value", "code_name1",{keyword:'DUTY'},'N');
    select_makes_sub("#auth_select", "/sysAuthAllGet", "auth_code", "auth_name",{},'N');
    $('#use_yn').select2();
}