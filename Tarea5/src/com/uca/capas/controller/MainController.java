package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;
import com.uca.capas.dao.StudentDAO;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {

		ModelAndView mav = new ModelAndView();
		
		List<Student> students = null;
		
		try {
			students = studentDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("message", "Buscar un estudiante");
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="idsearch") int id) {
		ModelAndView mav = new ModelAndView();
		Student student = studentDao.findOne(id);		
		if (student == null) mav.addObject("message", "No se encontraron coincidencias");
		else mav.addObject("message", "Resultado");
		mav.addObject("student", student);
		mav.setViewName("main");
		return mav;
		
	}
}
