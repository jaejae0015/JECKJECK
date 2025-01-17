package com.jaejaeproject.jeckjeck;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class Name : JeckjeckApplication.java
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
@RestController
@SpringBootApplication
@MapperScan("com.jaejaeproject.jeckjeck.com.mapper") 
public class JeckjeckApplication {

	
	@RequestMapping("/dockertest")
	String home() {
		return "Hello World!";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(JeckjeckApplication.class, args); 
	}

	@Bean 
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {				
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();		
		sessionFactory.setDataSource(dataSource); //의존성 주입 -servlet-context에서 해주는 작업				
		
		Resource[] res = new PathMatchingResourcePatternResolver()				
					.getResources("classpath:/mybatis/mapper/com/*.xml");				
		sessionFactory.setMapperLocations(res);						
		
		return sessionFactory.getObject();
	}
	
}
