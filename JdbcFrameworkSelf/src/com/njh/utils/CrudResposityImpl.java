package com.njh.utils;

import com.njh.connection.pool.ConnectionPool;
import com.njh.utils.interfaces.CrudResposity;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
public abstract class CrudResposityImpl<T> implements CrudResposity<T>, ResultHandler<T> {
	private DataSource ds = new ConnectionPool();
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet res;

	{
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(String sql, Object... params) {
		try {
			ppst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			ppst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(String sql, Object... params) {
		try {
			ppst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			ppst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(String sql, Object... params) {
		try {
			ppst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			ppst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}


	@Override
	public ResultSet query(String sql, Object... params) {
		CachedRowSet rs = null;
		try {
			rs = RowSetProvider.newFactory().createCachedRowSet();
			ppst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ppst.setObject(i + 1, params[i]);
			}
			res = ppst.executeQuery();
			rs.populate(res);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
			return rs;
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
	}
}
