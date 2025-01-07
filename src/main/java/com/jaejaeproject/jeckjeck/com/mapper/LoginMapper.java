package com.jaejaeproject.jeckjeck.com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jaejaeproject.jeckjeck.com.dto.LoginDTO;

/**
 * @Class Name : LoginMapper.java
 * @Description : 로그인 처리를 위한 Mapper Interface
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
@Mapper
public interface LoginMapper {
	public LoginDTO selectUserLoginInfo(LoginDTO loginUser);
}
