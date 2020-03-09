package com.sound.door.Common.Home;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Mapper.TestMapper;
import com.sound.door.mesManager.DTO.SYSDept;

@Service
public class HomeService{

	@Autowired
	private TestMapper testMapper;
	
	public List<SYSDept> sysDeptGet() {
		return testMapper.sysDeptGet();
	}


}
