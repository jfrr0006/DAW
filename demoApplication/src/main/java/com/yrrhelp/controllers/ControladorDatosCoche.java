package com.yrrhelp.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.DatosCoche;
import validator.ValidadorDatosCoche;

@Controller
@RequestMapping("/formularioCoche")
public class ControladorDatosCoche {
 
	@GetMapping
	public String verFormulario () {

		return "vistaFormularioCoche"; // nos redirige a la vista del formulario
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ValidadorDatosCoche()); // registramos el validador
    }
	
	@PostMapping
    public String manejarFormularioYaValidado(@Valid DatosCoche datosCoche, 
    		BindingResult result) {
		System.out.println("Formulario relleno");
		// si hay errores volvemos a la vista del formulario
		if ( result.hasErrors() ) {
			return "vistaFormularioCoche";
		}
		
		// si no hay errores, manejamos los datos validados...
		
		return "home";
		
	}
	
	@ModelAttribute("datosCoche")
	public DatosCoche populateForm() {
	     return new DatosCoche(); // creamos el bean para que se pueda poblar
	}
	
}