package com.njh.utils.bean;

public class ColnumsBean {
	private String tabname;
	private String colname;
	private String type;
	private String isnullable;
	private String coldescribe;
	
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsnullable() {
		return isnullable;
	}
	public void setIsnullable(String isnullable) {
		this.isnullable = isnullable;
	}
	public String getColdescribe() {
		return coldescribe;
	}
	public void setColdescribe(String coldescribe) {
		this.coldescribe = coldescribe;
	}
	public ColnumsBean(String tabname, String colname, String type, String isnullable, String coldescribe) {
		super();
		this.tabname = tabname;
		this.colname = colname;
		this.type = type;
		this.isnullable = isnullable;
		this.coldescribe = coldescribe;
	}
	
}
