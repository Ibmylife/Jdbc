package com.njh.utils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.njh.connection.pool.ConnectionPool;
import com.njh.utils.interfaces.OrmResposity;
@SuppressWarnings("all")
public abstract class OrmResposityImpl<T> implements OrmResposity<T>, ResultHandler<T> {
	private DataSource ds = new ConnectionPool();
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet res;
	private Class o;

	{
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> query(String sql, Class t, Object... params) {
		try {
			ppst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			this.o = t;
			res = ppst.executeQuery();
			return this.handle(res);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	@Override
	public List<T> handle(ResultSet rs) {
		List<T> list = new ArrayList<>();
		T nis = null;
		ResultSetMetaData metaData;
		try {
			metaData = res.getMetaData();
			// 查询到的数据列数
			int count = metaData.getColumnCount();

			Method[] methods = o.getMethods();
			while (res.next()) {
				nis = (T) o.newInstance();
				list.add(nis);
				for (int i = 1; i <= count; i++) {
					for (int j = 0; j < methods.length; j++) {
						if (methods[j].getName().toLowerCase()
								.equals(("set" + metaData.getColumnLabel(i)).toLowerCase())) {
							Object tempobj = res.getObject(i);
							if (tempobj == null) {
								tempobj = convert(methods[j].getParameters()[0].getParameterizedType().toString());
							}
							methods[j].invoke(nis, tempobj);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private Object convert(String t) {
		switch (t) {
		case "int":

		case "float":

		case "double":

		case "long":
			return 0;

		default:
			return null;
		}
	}
	private void close() {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ppst != null) {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		o = null;
	}

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> query(T t, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
