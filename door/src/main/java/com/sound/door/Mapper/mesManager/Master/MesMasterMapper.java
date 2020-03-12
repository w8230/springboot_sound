package com.sound.door.Mapper.mesManager.Master;

import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Master.DTO.SYS_BOARD_CD;
import com.sound.door.mesManager.Master.DTO.SYS_CARGO_CD;
import com.sound.door.mesManager.Master.DTO.SYS_LINE_CD;
import com.sound.door.mesManager.Master.DTO.SYS_MSG_CD;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesMasterMapper {

    //메세지관리-------------------------
    //메세지관리 메세지 목록
    List<SYS_MSG_CD> sysMsgGet(Page p);
    //메세지관리 메세지 추가
    Message sysMsgAdd(SYS_MSG_CD smc);
    //메세지관리 메세지 수정 시 그리드에서 하나의 항목 값 조회
    SYS_MSG_CD sysMsgOneGet(Page p);
    //메세지관리 메세지 삭제
    Message sysMsgDelete(Page p);

    //게시판관리-------------------------
    //게시판관리 게시판 목록
    List<SYS_BOARD_CD> sysBoardGet(Page p);
    Message sysBoardAdd(SYS_BOARD_CD sbc);
    SYS_BOARD_CD sysBoardOneGet(Page p);
    Message sysBoardDelete(Page p);

    //창고관리
    List<SYS_CARGO_CD> sysCargoGet(Page p);
    SYS_CARGO_CD sysCargoOneGet(Page p);
    Message sysCargoAdd(SYS_CARGO_CD scc);
    Message sysCargoDelete(Page p);
    List<SYS_CARGO_CD> sysCargoBAllGet(Page p);


    //라인정보
    SYS_LINE_CD sysProdLineOneGet(Page p);
    List<SYS_LINE_CD> sysProdLineGet(Page p);
    Message sysProdLineAdd(SYS_LINE_CD slc);
    Message sysProdLineDelete(Page p);


}
