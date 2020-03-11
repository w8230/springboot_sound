package com.sound.door.Common.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sound.door.Common.Auth.Auth;
import com.sound.door.Common.Auth.AuthService;
import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.Function.ReturnFunction;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <javadoc>
 * Handler 세팅
 *
 * @author 김재일
 * @version 1.0
 * @since 2019-11-14
 **/
@Component
@SessionAttributes("userData")
public class Handler extends HandlerInterceptorAdapter{
	
	@Autowired
    private AuthService authService;
	
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();

        
        Session lv = new Session();
        lv.setUser_code("admin");
        lv.setUser_name("관리자");
   
        request.getSession().setAttribute("userData", lv);
        Session sessionData = (Session) session.getAttribute("userData");
        
        
        request.getSession().setAttribute("userData", sessionData);
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
            } else if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {

            } else{
            	 if (request.getServletPath().equals("/") || request.getServletPath().equals("/loginAction")) { // left 메뉴가 없을시
                     authService.model_menu_setting(request);
                 } else {
	            	Page p = new Page();
	                p.setKeyword(request.getServletPath().substring(1));
	                SYSAuthProgram sap = authService.menuAuth(request, p);
	                if (sap.getCheck_get().equals("N")) {
	                    response.setContentType("text/html; charset=UTF-8");
	                    PrintWriter out = response.getWriter();
	                    out.println("<script>alert(' 권한이 존재하지않습니다.\\n 메인페이지로 이동합니다.'); location.href='/';</script>");
	                    out.flush();
	                    return false;
	                }
	
	                ArrayList<List<Auth>> authAllSubSelect = (ArrayList<List<Auth>>) authService.authAllSubSelect(request); // 권한에 맞는 전체 리스트
	                ReturnFunction returnFunction = new ReturnFunction();
	
	                request.setAttribute("allSub_list", authAllSubSelect);
	                Auth av1 = returnFunction.authMenu(request, authAllSubSelect);
	                String under_name = av1.getParent_menu_code();
	                authService.model_menu_setting(request, request.getServletPath().substring(1), under_name.substring(0, under_name.length() - 1), under_name);
	            	
	            	
	            	return true;
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
