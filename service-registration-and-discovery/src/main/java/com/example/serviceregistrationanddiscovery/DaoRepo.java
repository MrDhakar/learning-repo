package com.example.serviceregistrationanddiscovery;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRepo implements Serializable{

	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;
	
	/* @Autowired */
	private JdbcTemplate jdbcTemplate;
	
	String userQuery= "SELECT ID,NAME FROM USER";
	
	String userLeadQuery = "SELECT ID,DESC,EMAIL,USER_ASSIGN_ID,REPEAT_FLAG \r\n"
			+ "FROM USER_LEAD \r\n"
			+ "WHERE USER_ASSIGN_ID IS NULL"; 
	
	
	List<User> getUsers(){
		Map <String,String> map = new HashMap<>();
		
		return (List<User>) jdbcTemplate.query(userQuery,(ResultSetExtractor<User>) map);
		
	}
	
	
	List<UserLead> getUserLeadList(){
		Map <String,String> map = new HashMap<>();
		
		return (List<UserLead>) jdbcTemplate.query(userLeadQuery,(ResultSetExtractor<UserLead>) map);
		
	}
	
	List<UserLead> updateLeadList(){
		Map <String,String> map = new HashMap<>();
		
		return (List<UserLead>) jdbcTemplate.query(userLeadQuery,(ResultSetExtractor<UserLead>) map);
		
	}

}
