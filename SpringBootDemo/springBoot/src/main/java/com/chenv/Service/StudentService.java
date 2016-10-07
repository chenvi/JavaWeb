package com.chenv.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenv.Dao.StudentDao;
import com.chenv.Entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return this.studentDao.getAllStudents();
	}
}
