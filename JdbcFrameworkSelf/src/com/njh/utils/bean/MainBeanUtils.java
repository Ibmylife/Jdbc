package com.njh.utils.bean;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.njh.connection.pool.ConnectionPool;
import com.njh.utils.ConfigDb;


public class MainBeanUtils {
	private  static Connection con ;
	private  static String name ;
	private static DatabaseMetaData metaData;
	static{
		try {
			ConnectionPool connpol=new ConnectionPool();
			
			con=connpol.getConnection();
			
			metaData = con.getMetaData();
			
			name=(String)ConfigDb.getInstance().getPro().getProperty("url");
			
			String[] split = name.split("/");
			name=split[split.length-1];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 生成bean类
	@Test
	public void test2() {
		try {
			MethodTableToJavaBean(name);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 具体某个数据库的某个数据表生成实体类
	 * 
	 * @param databasename
	 * @throws Exception
	 */
	public static void MethodTableToJavaBean(String databasename) throws Exception {
		// 获取表
		ResultSet rs = metaData.getTables(null, databasename, "%", new String[] { "TABLE" });
		while (rs.next()) {
			MethodColumnsToJavaBean(databasename, rs.getString("TABLE_NAME"));
		}
		rs.close();
	}

	/**
	 * 将具体某个数据库的某个数据表生成实体类
	 * 
	 * @param databasename
	 * @param tablesname
	 * @throws Exception
	 */
	public static void MethodColumnsToJavaBean(String databasename, String tablesname) throws Exception {
		
		File file = new File("src/com/njh/bean/"+tablesname.substring(0, 1).toUpperCase() + tablesname.substring(1) + ".java");
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		} else {
			file.createNewFile();
		}
		ResultSet rs = metaData.getColumns(null, databasename, tablesname, "%");
		List<ColnumsBean> list = new ArrayList<>();
		while (rs.next()) {
			String columnName = rs.getString("COLUMN_NAME");// 列名
			int nullAble = rs.getInt("NULLABLE");// 是否允许为null
			int dataType = rs.getInt("DATA_TYPE"); // 对应的java.sql.Types类型
			String remarks = rs.getString("REMARKS");// 列描述
			String typevalues = TypeConverter.contverter(dataType);
			ColnumsBean col = new ColnumsBean(tablesname.substring(0, 1).toUpperCase() + tablesname.substring(1),
					columnName, typevalues, nullAble == 1 ? "可为空" : "不可为空", remarks);
			list.add(col);
		}
		ProduceJavaBean.produceMethod(list, file);

	}
}
