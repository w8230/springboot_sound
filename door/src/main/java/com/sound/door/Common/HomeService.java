<<<<<<< HEAD
package com.sound.door.Common;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Mapper.TestMapper;

@Service
public class HomeService{

	@Autowired
	private TestMapper testMapper;
	  
	public List<SYSDept> sysDeptGet() {
		
		return testMapper.sysDeptGet();
	}


}
=======
package com.sound.door.Common;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Mapper.TestMapper;

@Service
public class HomeService{

	@Autowired
	private TestMapper testMapper;
	
	public List<SYSDept> sysDeptGet() {
		return testMapper.sysDeptGet();
	}


}
=======
package com.sound.door.Common;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.door.Mapper.TestMapper;

@Service
public class HomeService{

	@Autowired
	private TestMapper testMapper;
	
	public List<SYSDept> sysDeptGet() {
		return testMapper.sysDeptGet();
	}


}
>>>>>>> branch 'master' of https://github.com/w8230/w_sound.git
