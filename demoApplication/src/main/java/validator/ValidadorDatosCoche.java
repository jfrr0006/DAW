package validator;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.DatosCoche;
 
 
public class ValidadorDatosCoche implements Validator {
	
	private static final int AÑO_ACTUAL = 
		Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()));	
 
	@Override
	public boolean supports(Class<?> clazz) {		
		return DatosCoche.class.equals(clazz); // clase del bean al que da soporte este validador
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		
		DatosCoche datosCoche = (DatosCoche) target;
		
		// la matrícula es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", "field.matricula.required", 
				"La matrícula es obligatoria");
		
		// debe tener un formato correcto del tipo: 1111-BBB o B-2222-MM
		validarFormatoMatricula(datosCoche.getMatricula(), errors); // valida la matricula por expresión regular
		
		// el modelo es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "field.modelo.required", 
			"El modelo es obligatorio");
		
		// el año debe ser válido no puede ser mayor que el actual
		if ( datosCoche.getAnho() < 1900 || datosCoche.getAnho() > AÑO_ACTUAL ) {
			errors.rejectValue("anho", "field.anho.invalid", "El año es incorrecto");
		}	
		
		// si no hay errores relacionados con el campo año
		if ( ! errors.hasFieldErrors("anho")) {
		
			// para los coches de año distinto al actual, validamos que no tengan más de 100.000 km
			if ( datosCoche.getAnho() < AÑO_ACTUAL ) {
				
				if ( datosCoche.getKilometros() < 0 ) {
					errors.rejectValue("kilometros", "field.kilometros.invalid", 
							"Los kilómetros son incorrectos");
				}
				
				if ( datosCoche.getKilometros() > 100000 ) {
					errors.rejectValue("kilometros", "field.kilometros.toomany", 
							"No se aceptan coches de más de 100000 km");
				}
			
			}		
		}		
		
	}
		
	private void validarFormatoMatricula (String matricula, Errors errors) {
		if (matricula.matches("[a-zA-Z]{1,3}-\\d{4}-[a-zA-Z]{1,4}|\\d{4}-[a-zA-Z]{3}") ) {
			return;
		} else {
			errors.rejectValue("matricula", "field.matricula.invalid", "El formato de la matricula no es correcto, solo se admiten españolas, separar letras de números con guiones.");
		}
		
	}
 
}