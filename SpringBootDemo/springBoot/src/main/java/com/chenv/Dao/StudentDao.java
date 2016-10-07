package com.chenv.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chenv.Entity.Student;

@SuppressWarnings("serial")
@Repository
public class StudentDao {
	private static Map<Integer, Student> students;
	
	static{
		students = new HashMap<Integer,Student>(){
			{
				put(1, new Student(1, "A", "Computer"));
				put(2, new Student(2, "B", "Math"));
				put(3, new Student(3, "C", "Art"));
			}
		};
		
	}
	
	public Collection<Student> getAllStudents(){
		return this.students.values();
	}
}
