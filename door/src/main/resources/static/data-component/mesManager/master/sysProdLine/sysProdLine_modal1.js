////////////////////////////시작 함수/////////////////////////////////////
function modal_start1() {
    selectBox_modal1();
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
            ccn_ajax("/sysProdLineAdd", modal_objact).then(function (data) {
                if (data.result === 'NG') {
                    alert(data.message);
                } else {
                    if (main_data.check === "I") {
                        get_btn(1);
                    } else {
                        get_btn($("#mes_grid").getGridParam('page'));
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


function selectBox_modal1() {
    select_makes("#dept_select", "/sysDeptAllGet", "dept_code", "dept_name");
    $('#line_type_select').select2();

}
// 유효성 검사
function effectiveness1(modal_objact) {
    if (modal_objact.dept_code === '') {
        alert("부서코드를 선택해주세요");
        return false;
    } else if (modal_objact.line_code === '') {
        alert("공정코드를 입력해주세요");
        return false;
    } else if (modal_objact.line_name === '') {
        alert("생산공정명을 입력해주세요");
        return false;
    } else if (modal_objact.line_char === '') {
        alert("코드를 입력해주세요");
        return false;
    } else {
        return true;
    }
}
