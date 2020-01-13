package com.ejerciciosSpring.ejerciciosSpring.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ejerciciosSpring.ejerciciosSpring.modelo.Persona;
import com.ejerciciosSpring.ejerciciosSpring.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService {
	private static final Log LOG= LogFactory.getLog(ExampleServiceImp.class);
	@Override
	public List<Persona> getListPersona() {
		List<Persona>listaPersonas=new ArrayList<>();
		listaPersonas.add(new Persona("Jesus",53));
		listaPersonas.add(new Persona("Juan",33));
		listaPersonas.add(new Persona("Amanda",25));
		listaPersonas.add(new Persona("Luis",83));
		LOG.info("Bienvenido al servicio");
		return listaPersonas;
	}

}
