package com.njh.utils;

import java.sql.ResultSet;
import java.util.List;

/**
 * 结果集处理
 * @author Administrator
 * @param <T>
 *
 */
public interface ResultHandler<T> {
	 List<T> handle(ResultSet rs);
}
