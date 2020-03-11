package com.sound.door.Mapper.mesManager.User;


import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MesUserMapper {
    List<SYS_DEPT_CD> sysDeptGet(Page p);
}
