package com.poi.service_impl;

import java.util.List;

import javax.annotation.Resource;

import com.poi.bean.Teacher;
import com.poi.dao.TeacherDao;
import com.poi.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
@Resource 
private TeacherDao teacherDao;
	@Override
	public List<Teacher> getTeachers() {
		return teacherDao.getTeachers();
	}
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

}
