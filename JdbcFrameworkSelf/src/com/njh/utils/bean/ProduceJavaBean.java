package com.njh.utils.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


public class ProduceJavaBean {
	private static FileOutputStream fos=null;
	protected static void produceMethod(List<ColnumsBean> list,File desc) throws Exception{
		fos=new FileOutputStream(desc); 
		StringBuffer sb=new StringBuffer();
		sb.append("package com.njh.bean ;\n");
		sb.append("import java.util.*;\n"+
				  "public class "+list.get(0).getTabname()+"{\n");
		for(ColnumsBean temp:list){
		sb.append("\t private " + temp.getType() + " " + temp.getColname() + ";\n");
		}
		for(ColnumsBean temp:list){
			String name=temp.getColname().substring(1);
			name=temp.getColname().substring(0, 1).toUpperCase()+name;
			sb.append("\t public void set" + name+ "(" + temp.getType() + " " +  temp.getColname() + "){\n");
			sb.append("\t\t this." + temp.getColname() + "=" + temp.getColname() + ";\n");
			sb.append("\t}\n");
			sb.append("\t public " + temp.getType() + " get" + name + "(){\n");
			sb.append("\t\t return " + temp.getColname() + ";\n");
			sb.append("\t}\n");
		}
		sb.append("}");
		fos.write(sb.toString().getBytes());
		fos.close();
	}
}
