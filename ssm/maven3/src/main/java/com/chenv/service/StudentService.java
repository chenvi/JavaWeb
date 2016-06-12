package com.chenv.service;


import java.util.List;

import com.chenv.pojo.Student;

public interface StudentService {
	public Student getStudentById(int studentId);
	public Student getStudentByName(String studentName);
	public void insertStudent(List<Student> students);
//	public void insertStudent(Student student);
	public void deleteAll();
}