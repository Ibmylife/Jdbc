package com.njh.utils.interfaces;

import java.util.List;

public interface OrmResposity<T> {
	void insert(T t);
	void delete(T t);
	void update(T t);
	List<T> query(T t ,String id);
	List<T> query(String sql, @SuppressWarnings("rawtypes") Class t, Object... params);
}
