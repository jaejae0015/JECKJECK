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

@MapperScan("com.jaejaeproject.jeckjeck.com.mapper") 
@SpringBootApplication
public class JeckjeckApplication {

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
