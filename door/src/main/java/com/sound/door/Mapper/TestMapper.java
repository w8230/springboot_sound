package com.sound.door.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sound.door.Common.SYSDept;

@Repository
public interface TestMapper {

	List<SYSDept> sysDeptGet();


}
