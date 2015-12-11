package com.phearun.webapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phearun.webapp.model.dao.StudentDAO;
import com.phearun.webapp.model.dto.StudentDTO;

@Controller
public class MainController {

	@Autowired
	StudentDAO student;
	
	@RequestMapping(value = {"/","home", "index"} ,  method = RequestMethod.GET)
	public String homePage(ModelMap model){
		
		ArrayList<StudentDTO> students = student.getStudent();
		model.addAttribute("student",students);
		return "home";
	}
	
	@RequestMapping(value = "formstudent",  method = RequestMethod.GET)
	public String formStudent(ModelMap model){
		model.addAttribute("student",new StudentDTO());
		return "addstudent";
	}
	
	@RequestMapping(value = "addstudentinfo",  method = RequestMethod.POST)
	public String addStudent(StudentDTO stu, ModelMap model){
		if(student.addStudent(stu))
			model.addAttribute("success","success");
		else
			model.addAttribute("success","fail");
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "delete",  method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("id") int id, ModelMap model){
		if(student.deleteStudent(id))
			model.addAttribute("success","success");
		else
			model.addAttribute("success","fail");
			
		return "redirect:/home";
	}
	
	@RequestMapping(value = "viewstudent",  method = RequestMethod.GET)
	public String viewPage(@RequestParam("id") int id, ModelMap model){
		StudentDTO studentDTO = student.viewStudent(id);
		model.addAttribute("student", studentDTO);
		return "viewstudent";
	}
	
	@RequestMapping(value = "editstudent", method = RequestMethod.GET)
	public String editPage(@RequestParam("id") int id, ModelMap model){
		model.addAttribute("status", 1);
		model.addAttribute("student",new StudentDTO());
		
		StudentDTO st = student.getOneStudent(id);
		model.addAttribute("onestudent", st);
		
		return "addstudent";
	}
	
	@RequestMapping(value = "updatestudent", method = RequestMethod.POST)
	public String updateStudent(StudentDTO studentDTO, ModelMap model){
		
		if(student.updateStudent(studentDTO))
			model.addAttribute("success","success");
		else
			model.addAttribute("success","fail");
		return "redirect:/home";
	}

}
