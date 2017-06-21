package com.poi.dao;

import java.util.List;

import com.poi.bean.Teacher;

public interface TeacherDao {

	public List<Teacher> getTeachers();
	
	/*
	 * 添加
	 */
	public void addTeacher(Teacher teacher);
}
