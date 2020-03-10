package com.sound.door.Mapper.Common.Auth;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sound.door.Common.Auth.Auth;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.Interceptor.Session;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

@Repository
public interface AuthMapper {

    List<Auth> authSubSelect(Session session);
    SYSAuthProgram menuAuth(Page p);
    List<Auth> authMainSelect(Session session);
}