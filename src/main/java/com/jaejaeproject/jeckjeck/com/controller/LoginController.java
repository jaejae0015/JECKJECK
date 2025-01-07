package com.jaejaeproject.jeckjeck.com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;
import com.jaejaeproject.jeckjeck.com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	//@Autowired
	//MyUtil myUtil;	//[TO-DO] 페이징 처리에 대한 클래스 작성 예정
	
	/**
	 * Description : 사용자 로그인처리
	 * 
	 * @param param
	 * @return resultMap
	 * @throws Exception
	 */
	@GetMapping(value="/")
	public String login()  throws Exception{
		
		return "login";
	}
	
	
	/**
	 * Description : 사용자 로그인처리
	 * 
	 * @param param
	 * @return resultMap
	 * @throws Exception
	 */
	@GetMapping("/com/login.do")
	public String loginProc()  throws Exception{
		
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		LoginDTO testUser =new LoginDTO();
		testUser.userid="admin";
		
		
		LoginDTO loginInfo = loginService.getLoginUserInfo(testUser);
		if(loginInfo != null) {
			resultMap.put("loginUserInfo",loginInfo);
			resultMap.put("success", true);
			return "login";
		}else {
			resultMap.put("success", false);
			return "error";
		}
		
	}
}
