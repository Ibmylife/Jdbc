package com.njh.test;


import java.util.List;

import org.junit.Test;

import com.njh.bean.*;
import com.njh.utils.OrmResposityImpl;

public class TemplateTest extends OrmResposityImpl<S_emp>{
	@Test
	public void test(){
		String sql="select * from s_emp";
		String[] params=new String[]{};
		
		List<S_emp> query = this.query(sql, S_emp.class, params);
		query.stream().forEach(System.out::println);
	}
}