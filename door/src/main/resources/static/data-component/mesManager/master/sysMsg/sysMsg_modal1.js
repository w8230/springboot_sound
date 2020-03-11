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
            ccn_ajax("/sysMsgAdd", modal_objact).then(function (data) {
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

function effectiveness1(modal_objact) {
    if (modal_objact.msg_code === '') {
        alert("메세지코드를 입력해주세요");
        return false;
    } else if (modal_objact.msg_name1 === '') {
        alert("메세지명1을 입력해주세요");
        return false;
    } else {
        return true;
    }
}
