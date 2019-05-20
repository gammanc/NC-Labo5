package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;
import com.uca.capas.dao.StudentDAO;

@Controller
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {

		log.info("Iniciando funcion main - " + log.getName());
		
		ModelAndView mav = new ModelAndView();
		
		List<Student> students = null;
		try {
			students = studentDao.findAll();
			log.info("Finalizo la busqueda en la base de datos");
		}catch(Exception e) {
			log.log(Level.SEVERE,"Exception ocurred",e);
		}
		
		mav.addObject("message", "Buscar un estudiante");
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="idsearch") int id) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			Student s = studentDao.findOne(id);
			if(s == null) { 
				students = studentDao.findAll();
				mav.addObject("message", "No se encontraron resultados");
			}
			else { 
				students = new ArrayList<Student>();
				students.add(s);
				mav.addObject("message", "Resultados");
			}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Exception ocurred",e);
		}
		
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","Agregar nuevo estudiante");
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			Student student = studentDao.findOne(id);
			if (student == null) mav.addObject("message", "No se encontró el registro");
			else {
				log.info("Eliminando estudiante");
				studentDao.delete(student);
			}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Exception ocurred",e);
		}
		
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		
		mav.addObject("message", "Se eliminó 1 estudiante");
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		
		Student student = studentDao.findOne(id);		
		if (student == null) mav.addObject("message", "No se encontró el registro");
		else {
			mav.addObject("message","Editar estudiante");
			mav.addObject("student", student);
		}
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping("/formData")
	public ModelAndView insert(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Nuevo estudiante");
			if(s == null) { studentDao.save(s, 1); log.info("agregando");}
			else { studentDao.save(s, 0);log.info("actualizando "+s.getcStudent());}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Exception ocurred",e);
		}
		
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		
		mav.addObject("message", "Buscar un estudiante");
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
}
