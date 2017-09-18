package com.njh.bean ;
public class S_dept{
	 private int id;
	 private String name;
	 private int region_id;
	 public void setId(int id){
		 this.id=id;
	}
	 public int getId(){
		 return id;
	}
	 public void setName(String name){
		 this.name=name;
	}
	 public String getName(){
		 return name;
	}
	 public void setRegion_id(int region_id){
		 this.region_id=region_id;
	}
	 public int getRegion_id(){
		 return region_id;
	}
}