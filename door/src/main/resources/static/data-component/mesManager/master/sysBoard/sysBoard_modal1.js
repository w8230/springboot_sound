////////////////////////////시작 함수/////////////////////////////////////
function modal_start1() {

}

////////////////////////////클릭 함수/////////////////////////////////////
//저장,수정 버튼
function addUdate_btn() {
    var modal_objact = value_return(".modal_value");
    if (modal_objact.files === ''){
        modal_objact.files = 0;
    }

    if (modal_objact.file_size === ''){
        modal_objact.file_size = 0;
    }
    if (effectiveness1(modal_objact)) {
        var text = '저장하겠습니까?';
        if (main_data.check === "U") {
            text = '수정하겠습니까?';
        }
        if (confirm(text)) {
            modal_objact.keyword = main_data.check;
            ccn_ajax("/sysBoardAdd", modal_objact).then(function (data) {
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
// 유효성 검사
function effectiveness1(modal_objact) {
    if (modal_objact.board_code === '') {
        alert("게시판코드를 입력해주세요");
        return false;
    } else if (modal_objact.board_en === '') {
        alert("영문명을 입력해주세요");
        return false;
    } else if (modal_objact.board_kr === '') {
        alert("한글명을 입력해주세요");
        return false;
    } else {
        return true;
    }
}

