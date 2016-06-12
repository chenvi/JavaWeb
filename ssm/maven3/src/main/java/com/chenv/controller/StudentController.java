package com.chenv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenv.pojo.Student;
import com.chenv.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
  @Resource
  private StudentService studentService;
  
  @RequestMapping("/showStudent")
  public String toIndex(HttpServletRequest request,Model model){
//    int studentId = Integer.parseInt(request.getParameter("id"));
    String studentName = request.getParameter("name");
//    Student student = this.studentService.getStudentById(studentId);
    Student student = this.studentService.getStudentByName(studentName);
    model.addAttribute("student", student);
    return "showStudent";
  }
}