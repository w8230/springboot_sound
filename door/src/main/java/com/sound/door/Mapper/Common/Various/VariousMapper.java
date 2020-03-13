package com.sound.door.Mapper.Common.Various;


import com.sound.door.mesManager.Master.DTO.SYS_COMMON_CD;
import com.sound.door.mesManager.User.DTO.SYS_DEPT_CD;
import org.springframework.stereotype.Repository;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

import java.util.List;


@Repository
public interface VariousMapper {

	SYSAuthProgram menuAuthGet(Page p);


    List<SYS_DEPT_CD> sysDeptAllGet(Page p);

    List<SYS_COMMON_CD> sysCommonAllGet(Page p);
}