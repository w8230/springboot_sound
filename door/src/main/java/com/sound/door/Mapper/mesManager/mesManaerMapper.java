package com.sound.door.Mapper.mesManager;

import org.springframework.stereotype.Repository;

import com.sound.door.Common.Interceptor.UserData;

@Repository
public interface mesManaerMapper {
	int validUser(UserData userData);
}
