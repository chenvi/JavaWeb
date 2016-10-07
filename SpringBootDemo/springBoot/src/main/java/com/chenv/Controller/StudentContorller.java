package com.chenv.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chenv.Entity.Student;
import com.chenv.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentContorller {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return this.studentService.getAllStudents();
	}
}
