package com.poi.service;

import java.util.List;

import com.poi.bean.Teacher;

public interface TeacherService {
	public List<Teacher> getTeachers();
	/*
	 * 添加
	 */
	public void addTeacher(Teacher teacher);
}
