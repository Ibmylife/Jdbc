package com.njh.utils.interfaces;

import java.sql.ResultSet;


/**
 * 此接口是操作数据库类,定义各种操作
 * @author Administrator
 * @param <T>
 *
 */
public interface CrudResposity<T> {
    void insert(String sql, Object...params);
	void delete(String sql,Object...params);
	void update(String sql,Object...params);
	ResultSet query(String sql,Object...params);
}
