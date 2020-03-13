////////////////////////////시작 함수/////////////////////////////////////

function modal_start1() {

}

////////////////////////////클릭 함수/////////////////////////////////////
//저장,수정 버튼
function addUdate_btn() {
    var modal_objact = value_return(".modal_value");
    if (effectiveness1(modal_objact)) {
        var text = '저장하겠습니까?';
        if (main_data.check === "U") {
            text = '수정하겠습니까?';
        }
        if (confirm(text)) {
            modal_objact.keyword = main_data.check;
            ccn_ajax("/sysCommonAdd", modal_objact).then(function (data) {
                if (data.result === 'NG') {
                    alert(data.message);
                } else {
                    if (main_data.check === "I") {
                        get_btn(1);
                    } else {
                        get_btn_post($("#mes_grid").getGridParam('page'));
                    }
                }
                $("#addDialog").dialog('close');
            }).catch(function (err) {
                alert("저장실패");
            });
        }
    }
}

////////////////////////////호출 함수/////////////////////////////////////

// 유효성 검사
function effectiveness1(modal_objact) {
    if (modal_objact.group_code === '') {
        alert("코드그룹을 입력해주세요");
        return false;
    } else if (modal_objact.code_value === '') {
        alert("코드를 입력해주세요");
        return false;
    } else if (modal_objact.code_name1 === '') {
        alert("명칭1을 입력해주세요");
        return false;
    } else {
        return true;
    }
}
