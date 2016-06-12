package com.chenv.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.dao.StudentMapper;
import com.chenv.pojo.Student;
import com.chenv.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentMapper student;

	@Override
	public Student getStudentById(int studentId) {
		return this.student.selectByPrimaryKey(studentId);
	}
	
	@Override
	public void insertStudent(List<Student> students) {
		for (Student student : students) {
			this.student.insert(student);
		}
	}

	@Override
	public Student getStudentByName(String studentName) {
		Student student = null;
			return this.student.selectByName(studentName);
	}

	@Override
	public void deleteAll() {
		this.student.deleteAll();
	}

//	@Override
//	public void insertStudent(Student student) {
//		this.student.insert(student);
//	}
 
	

}