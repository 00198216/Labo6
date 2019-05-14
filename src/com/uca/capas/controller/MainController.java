package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a la funcion init-main" + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;
		try {
			student = studentDao.findALL();
			log.info("Se termino de buscar en la base de datos");
		}
		catch(Exception e) {
			log.log(Level.SEVERE,"Exeption Occur",e);
		}
		
		mav.addObject("student", student);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value = "/Result", method= RequestMethod.POST)
	public ModelAndView formData(@RequestParam(value="id") int id ) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try {
			student = studentDao.findOne(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student", student);
		mav.setViewName("Result");
		
		return mav;
	}
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Se agrego un nuevo usuario");
			studentDao.save(s, 1);
		}catch(Exception e) {
			log.info("Error"+e.toString());
		}
		students=studentDao.findALL();
		log.info(students.get(0).getlName());
		mav.addObject("student", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("form");
		return mav;
	}
	
	
	@RequestMapping(value="/Delete", method= RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="name") String name ) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Se elimino un usuario");
			studentDao.delete(name);
		}catch(Exception e) {
			log.info("Error"+e.toString());
		}
		students=studentDao.findALL();
		log.info(students.get(0).getlName());
		mav.addObject("student", students);
		mav.setViewName("main");
		return mav;
	}
	
}


