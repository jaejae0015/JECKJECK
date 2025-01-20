package com.jaejaeproject.jeckjeck.com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;
import com.jaejaeproject.jeckjeck.com.service.LoginService;
import com.jaejaeproject.jeckjeck.util.MyUtil;

import jakarta.servlet.http.HttpSession;


/**
 * @Class Name : LoginController.java
 * @Description : 로그인 처리를 위한 Controller
 * @Modification Information
 * @
 * @ ModifyDate      Modifier              Comment
 * @ -----------    ----------    ---------------------------
 * @ 2025.01.07        서지애       		   최초 생성
 *
 *  @author 서지애
 *  @since 2025.01.07
 *  @version 1.0
 *  @see
 *
 */

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	MyUtil myUtil;	//[TO-DO] 페이징 처리에 대한 클래스 작성 예정
	
	/**
	 * Description : 로그인 화면
	 * 
	 * @param param
	 * @return resultMap
	 * @throws Exception
	 */
	@GetMapping(value="/")
	public String login() throws Exception{
		return "com/login";
	}
	
	/**
	 * Description : 사용자 로그인처리
	 * 
	 * @param param
	 * @param session
	 * @return resultMap
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/com/login.do")
	public HashMap<String,Object> loginProc(HttpSession session, @RequestParam HashMap<String,Object> param) throws Exception{
		
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		LoginDTO loginInfo = loginService.getLoginUserInfo(param);
		if(loginInfo != null) {
            session.setAttribute("loginUser", loginInfo);
			resultMap.put("success", true);
		}else {
			resultMap.put("success", false);
		}
		return resultMap;
	}
	
	/**
	 * Description : 메인화면
	 * 
	 * @param session
	 * @param model
	 * @return resultMap
	 * @throws Exception
	 */
	@GetMapping("/com/main.do")
	public String main(HttpSession session, Model model) throws Exception{
		
		LoginDTO loginUser = (LoginDTO) session.getAttribute("loginUser");
        if (loginUser != null) {
            model.addAttribute("loginUser", loginUser);
            return "com/main";
        } else {
            return "redirect:/com/login.do";
        }
	}
}
