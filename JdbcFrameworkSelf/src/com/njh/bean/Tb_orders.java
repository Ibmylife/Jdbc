package com.njh.bean ;
public class Tb_orders{
	 private int id;
	 private int good_id;
	 private int much;
	 public void setId(int id){
		 this.id=id;
	}
	 public int getId(){
		 return id;
	}
	 public void setGood_id(int good_id){
		 this.good_id=good_id;
	}
	 public int getGood_id(){
		 return good_id;
	}
	 public void setMuch(int much){
		 this.much=much;
	}
	 public int getMuch(){
		 return much;
	}
}