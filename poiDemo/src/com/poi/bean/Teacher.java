package com.poi.bean;

import java.io.File;
import java.util.Date;

public class Teacher {
private Integer id;
private String name;
private String sex;
private File user;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public File getUser() {
	return user;
}


public void setUser(File user) {
	this.user = user;
}

public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}
public Teacher(Integer id, String name, String sex, File user) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.user = user;
}
@Override
public String toString() {
	return id + "," + name+","+sex;
}

}
