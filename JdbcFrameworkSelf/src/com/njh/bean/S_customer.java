package com.njh.bean ;
public class S_customer{
	 private int id;
	 private String name;
	 private String phone;
	 private String address;
	 private String city;
	 private String state;
	 private String country;
	 private String zip_code;
	 private String credit_rating;
	 private int sales_rep_id;
	 private int region_id;
	 private String comments;
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
	 public void setPhone(String phone){
		 this.phone=phone;
	}
	 public String getPhone(){
		 return phone;
	}
	 public void setAddress(String address){
		 this.address=address;
	}
	 public String getAddress(){
		 return address;
	}
	 public void setCity(String city){
		 this.city=city;
	}
	 public String getCity(){
		 return city;
	}
	 public void setState(String state){
		 this.state=state;
	}
	 public String getState(){
		 return state;
	}
	 public void setCountry(String country){
		 this.country=country;
	}
	 public String getCountry(){
		 return country;
	}
	 public void setZip_code(String zip_code){
		 this.zip_code=zip_code;
	}
	 public String getZip_code(){
		 return zip_code;
	}
	 public void setCredit_rating(String credit_rating){
		 this.credit_rating=credit_rating;
	}
	 public String getCredit_rating(){
		 return credit_rating;
	}
	 public void setSales_rep_id(int sales_rep_id){
		 this.sales_rep_id=sales_rep_id;
	}
	 public int getSales_rep_id(){
		 return sales_rep_id;
	}
	 public void setRegion_id(int region_id){
		 this.region_id=region_id;
	}
	 public int getRegion_id(){
		 return region_id;
	}
	 public void setComments(String comments){
		 this.comments=comments;
	}
	 public String getComments(){
		 return comments;
	}
}