package com.jaejaeproject.jeckjeck.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;
import com.jaejaeproject.jeckjeck.com.mapper.LoginMapper;
import com.jaejaeproject.jeckjeck.com.service.LoginService;

/**
 * @Class Name : LoginServiceImpl.java
 * @Description : 로그인 처리를 위한 Service
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
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired 
	private LoginMapper loginMapper;
	
	@Override
	public LoginDTO getLoginUserInfo(LoginDTO loginUser) {
		System.out.println("##################"+loginUser.userid);
		LoginDTO loginInfo = loginMapper.selectUserLoginInfo(loginUser);
		
		System.out.println("@@@@@@@@@@@@@@@@@"+loginInfo.userid);
		return loginInfo;
	}

}
