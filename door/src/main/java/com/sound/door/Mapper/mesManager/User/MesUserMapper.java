package com.sound.door.Mapper.mesManager.User;


import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import com.sound.door.mesManager.User.DTO.SYS_USER_CD;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MesUserMapper {
    List<SYS_DEPT_CD> sysDeptGet(Page p);

    Message sysDeptAdd(SYS_DEPT_CD sdc);

    SYS_DEPT_CD sysDeptOneGet(Page p);

    Message sysDeptDelete(Page p);

    List<SYS_USER_CD> sysUserGet(Page p);

    Message sysUserAdd(SYS_USER_CD suc);

    SYS_USER_CD sysUserOneGet(Page p);

    Message sysUserDelete(Page p);
}
