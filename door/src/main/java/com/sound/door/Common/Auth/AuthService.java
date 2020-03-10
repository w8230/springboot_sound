package com.sound.door.Common.Auth;

import com.sound.door.Common.DataTransferObject.Page;
import com.sound.door.Common.Function.AuthFunction;
import com.sound.door.Common.Interceptor.Session;
import com.sound.door.Mapper.Common.Auth.AuthMapper;
import com.sound.door.mesManager.Auth.DTO.SYSAuthProgram;

//import com.sound.door.mesManager.Authority.DTO.SYSAuthProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <javadoc>
 * 메뉴구성 service
 * @author      김재일
 * @version     1.0
 * @since       2019-11-14
 **/
@Service
public class AuthService extends AuthFunction{

    @Autowired
    private AuthMapper authMapper;

    public List<Auth> authMainSelect(HttpServletRequest req) {
        return authMapper.authMainSelect(getSessionData(req));
    }
    
    
    public List<Auth> authMainSelect2(HttpServletRequest req) {
    	List<Auth> authMainList =  authMapper.authMainSelect(getSessionData(req));
    	
    	ArrayList<List<Auth>> authAllSubSelect = (ArrayList<List<Auth>>) authAllSubSelect(req);
    	
    	for (int i = 0; i < authMainList.size(); i++) {
    		for (int j = 0; j < authAllSubSelect.get(i).size(); j++) {
				if (authAllSubSelect.get(i).get(j).getLevel() == 3) {
					authMainList.get(i).setQuick_menu_code(authAllSubSelect.get(i).get(j).getMenu_code());
					break;
				}
			}
		}
    	
    	
    	
        return authMainList;
    }
    

    public List<?> authSubSelect(HttpServletRequest req, String keyword) {
        Session session = getSessionData(req);
        session.setKeyword(keyword);
        List<Auth> avList =  authMapper.authSubSelect(session);
        return gb_list(avList);
    }

    public List<?> authAllSubSelect(HttpServletRequest req) {
        Session session = getSessionData(req);
        List<Auth> avList = authMapper.authMainSelect(session);
        ArrayList<List<Auth>> allSubList = new ArrayList<>();
        ArrayList<List<Auth>> allSubList2 = new ArrayList<>();

        for (Auth Auth : avList) {
            session.setKeyword(Auth.getMenu_code());
            allSubList.add(authMapper.authSubSelect(session));
            allSubList2.add(authMapper.authSubSelect(session));
        }
        return  authAllSubSelect(allSubList,allSubList2);
    }

    public void model_menu_setting(HttpServletRequest req, String page_name, String top_menu_name, String under_name) {
        req.setAttribute("page_name",page_name);
        req.setAttribute("top_active",under_name);
        req.setAttribute("top_code",top_menu_name);
        req.setAttribute("under_active",page_name);
        req.setAttribute("main_list",authMainSelect2(req));
        req.setAttribute("left_list",authSubSelect(req, top_menu_name));
        req.setAttribute("bestTop_name",top_menu_name);
    }

    public void model_menu_setting(HttpServletRequest req){
        req.setAttribute("main_list",authMainSelect2(req));
        //req.setAttribute("allSub_list",authAllSubSelect(req));
    }

    public SYSAuthProgram menuAuth(HttpServletRequest req, Page p){
        p.setUser_code(getSessionData(req).getUser_code());
        return authMapper.menuAuth(p);
    }

}
