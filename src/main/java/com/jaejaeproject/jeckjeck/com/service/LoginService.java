package com.jaejaeproject.jeckjeck.com.service;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;

/**
 * @Class Name : LoginService.java
 * @Description : 로그인 처리를 위한 Service Interface
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
public interface LoginService {
	public LoginDTO getLoginUserInfo(LoginDTO loginUser);
}
