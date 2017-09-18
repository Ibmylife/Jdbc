package com.njh.connection.pool;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.njh.utils.ConfigDb;

public class ConnectionPool implements DataSource {
	private final static List<Connection> connPool = new ArrayList<>();
	{
		getcon();
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new SQLFeatureNotSupportedException("暂不支持");
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new SQLException("暂不支持");
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection con = null;
		int count = 0;
		// 获取连接池中对象
		while (con == null) {
			if (count >= 50) {
				// TODO 重新获取一个对象
			}
			count++;
			try {
				con = connPool.remove(0);
			} catch (Exception e) {
				try {
					Thread.sleep(100);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		Connection con1 = con;
		return (Connection) Proxy.newProxyInstance(ConnectionPool.class.getClassLoader(),
				new Class[] { java.sql.Connection.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getName().trim().equals("close")) {
							connPool.add(con1);
							return null;
						} else {
							return method.invoke(con1, args);
						}
					}
				});

	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		throw new SQLException("暂不支持");
	}

	private void getcon() {
		Properties pro = ConfigDb.getInstance().getPro();
		try {
			Class.forName(pro.getProperty("driver"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < Integer.parseInt((String) pro.get("maxNum")); i++) {

			try {
				connPool.add(DriverManager.getConnection(pro.getProperty("url"), pro));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
