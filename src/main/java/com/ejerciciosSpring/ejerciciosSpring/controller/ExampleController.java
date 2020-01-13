package com.ejerciciosSpring.ejerciciosSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejerciciosSpring.ejerciciosSpring.service.ExampleService;

//CONTROLADOR PARA EL EJERCICIO DE LOS SERVICIOS
@Controller
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@GetMapping("/exampleStringLista")
	public String exampleStringLista(Model model) {
		model.addAttribute("personas",exampleService.getListPersona());
		
		return ("/insertarLista2");
		
	}
	
	@GetMapping("/exampleMAVlista")
	public ModelAndView exampleMAVlista() {
		ModelAndView mav=new ModelAndView("insertarLista2");
		mav.addObject("personas",exampleService.getListPersona());
		return mav;
	}
}
