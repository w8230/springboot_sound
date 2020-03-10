package com.sound.door.Mapper.Common.Various;


import org.springframework.stereotype.Repository;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;



@Repository
public interface VariousMapper {

	SYSAuthProgram menuAuthGet(Page p);

    
}