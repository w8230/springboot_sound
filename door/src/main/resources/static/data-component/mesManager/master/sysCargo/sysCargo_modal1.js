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

            ccn_ajax("/sysCargoAdd", modal_objact).then(function (data) {
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
function effectiveness1(modal_objact) { // 유효성 검사
    if (modal_objact.cargo_grp_code === '') {
        alert("구분을 선택해주세요");
        return false;
    } else if (modal_objact.cargo_code === '') {
        alert("창고코드를 입력해주세요");
        return false;
    } else if (modal_objact.cargo_name === '') {
        alert("창고명을 입력해주세요");
        return false;
    }  else {

        return true;
    }
}


function selectBox_modal1() {
    $('#use_yn').select2();
}
