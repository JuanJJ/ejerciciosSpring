package com.ejerciciosSpring.ejerciciosSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recibir")
public class RecibirDatosController {
	//localhost:8080/recibir/devolverDatoGet?nombreGet=JesusAlcocer
	@GetMapping("/devolverDatoGet")
	public ModelAndView devolverDatoGet(@RequestParam(name = "nombreGet", required = false, defaultValue = "NULL") String nombre) {
		ModelAndView mav= new ModelAndView("devolverDatoGet");
		mav.addObject("nombreGet_mav", nombre);
		return mav;
	}
	// localhost:8080/recibir/devolverDatoGetDirectamente/Jesus%20Alcocer
	@GetMapping("/devolverDatoGetDirectamente/{nombreGet}")
	public ModelAndView devolverDatoGetDirectamente(@PathVariable("nombreGet") String nombre) {
		
		ModelAndView mav= new ModelAndView("devolverDatoGet");
		mav.addObject("nombreGet_mav", nombre);
		return mav;
	}
}
