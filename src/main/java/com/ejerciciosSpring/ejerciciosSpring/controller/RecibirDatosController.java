package com.ejerciciosSpring.ejerciciosSpring.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ejerciciosSpring.ejerciciosSpring.modelo.Persona;

@Controller
@RequestMapping("/recibir")
public class RecibirDatosController {
	
	//SE INSTANCIA UN OBJETO DE TIPO LOG PARA PODER ENVIAR LOS LOG
	private static final Log LOGGER=LogFactory.getLog(RecibirDatosController.class);
	
	
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
	
	
	@GetMapping("/formulario")
	public String showForm(Model model) {
		//PARA VER UN LOG EN LA CONSOLA
		LOGGER.info("Info Trace");
		LOGGER.warn("Warnig Trace");
		LOGGER.error("Error Trace");
		LOGGER.debug("Debug Trace");
		//SE AÑADE UN ATRIBUTO AL MODELO DE TIPO PERSONA
		model.addAttribute("person", new Persona());
		return "formulario";
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@ModelAttribute("person")Persona person) {
		LOGGER.info("Metodo : ' addperson ' --Parametros :'"+person+"'");
		ModelAndView mav=new ModelAndView("Result");
		mav.addObject("person",person);
		return mav;
	}
	
	//FORMA PARA REDIRIGIR A UNA RUTA
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/recibir/formulario");
	}
}
