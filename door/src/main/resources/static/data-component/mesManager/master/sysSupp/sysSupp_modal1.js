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

            ccn_ajax("/sysSuppAdd", modal_objact).then(function (data) {
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
    if (modal_objact.supp_code === '') {
        alert("업체코드를 입력해주세요");
        return false;
    } else if (modal_objact.corp_type1 === 'N' && modal_objact.corp_type2 === 'N' && modal_objact.corp_type1 === 'N') {
        alert("업체구분을 하나라도 Y 입력해주세요.");
        return false;
    } else {
        return true;
    }
}

function selectBox_modal1(){
    $('#corp_type1').select2();
    $('#corp_type2').select2();
    $('#corp_type3').select2();
    $('#use_yn').select2();
}