package com.sound.door.Common.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <javadoc>
 * Handler 세팅
 *
 * @author 김재일
 * @version 1.0
 * @since 2019-11-14
 **/
@Component
public class Handler extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();

        UserData sessionData = (UserData) session.getAttribute("userData");
        response.setHeader("pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "No-store");
        response.setDateHeader("Expires", 1L);

        try {
            if (ObjectUtils.isEmpty(sessionData)) {
                if (!request.getServletPath().equals("/")) {
                    response.setContentType("text/html; charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<script>alert(' 회원데이터가 존재하지않습니다.\\n 로그인페이지로 이동합니다.'); location.href='/login';</script>");
                    out.flush();
                    out.close();
                    return false;
                } else {
                    response.setContentType("text/html; charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<script>location.href='/login';</script>");
                    out.flush();
                    out.close();
                    return false;
                }
            } else{
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
