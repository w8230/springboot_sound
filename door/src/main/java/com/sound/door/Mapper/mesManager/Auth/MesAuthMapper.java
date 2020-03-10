package com.sound.door.Mapper.mesManager.Auth;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sound.door.Common.Auth.Auth;
import com.sound.door.Common.DataTransferObject.Message;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.mesManager.Auth.DTO.SYSAuth;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;


@Repository
public interface MesAuthMapper {

	List<SYSAuth> sysAuthGet(Page p);

	SYSAuth sysAuthOneGet(Page p);

	Message sysAuthAU(SYSAuth sysAuth);

	Message sysAuthDelete(Page p);

	List<Auth> menuAllGet();

	List<Page> sysAuthAllGet(Page p);

	List<SYSAuthProgram> sysAuthProgramGet(Page p);

	Message sysAuthProgramAdd(Page p);
	
}
