package com.njh.bean;
import java.util.*;
public class S_emp{
	 private int id;
	 private String last_name;
	 private String first_name;
	 private String userid;
	 private Date start_date;
	 private String comments;
	 private int manager_id;
	 private String title;
	 private int dept_id;
	 private float salary;
	 private String commission_pct;
	 public void setId(int id){
		 this.id=id;
	}
	 public int getId(){
		 return id;
	}
	 public void setLast_name(String last_name){
		 this.last_name=last_name;
	}
	 public String getLast_name(){
		 return last_name;
	}
	 public void setFirst_name(String first_name){
		 this.first_name=first_name;
	}
	 public String getFirst_name(){
		 return first_name;
	}
	 public void setUserid(String userid){
		 this.userid=userid;
	}
	 public String getUserid(){
		 return userid;
	}
	 public void setStart_date(Date start_date){
		 this.start_date=start_date;
	}
	 public Date getStart_date(){
		 return start_date;
	}
	 public void setComments(String comments){
		 this.comments=comments;
	}
	 public String getComments(){
		 return comments;
	}
	 public void setManager_id(int manager_id){
		 this.manager_id=manager_id;
	}
	 public int getManager_id(){
		 return manager_id;
	}
	 public void setTitle(String title){
		 this.title=title;
	}
	 public String getTitle(){
		 return title;
	}
	 public void setDept_id(int dept_id){
		 this.dept_id=dept_id;
	}
	 public int getDept_id(){
		 return dept_id;
	}
	 public void setSalary(float salary){
		 this.salary=salary;
	}
	 public float getSalary(){
		 return salary;
	}
	 public void setCommission_pct(String commission_pct){
		 this.commission_pct=commission_pct;
	}
	 public String getCommission_pct(){
		 return commission_pct;
	}
	@Override
	public String toString() {
		return "S_emp [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", userid=" + userid
				+ ", start_date=" + start_date + ", comments=" + comments + ", manager_id=" + manager_id + ", title="
				+ title + ", dept_id=" + dept_id + ", salary=" + salary + ", commission_pct=" + commission_pct + "]";
	}
	 
}