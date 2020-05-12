package models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;



public class User {

	@NotBlank(message="El nombre de usuario no puede estar vacío")
	@Size(min=4, max=16, message="El nombre de usuario debe tener entre 4 y 16 caracteres")
	  private String username;
	
	@Pattern(regexp="^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$", message="La fecha tiene que tener el formato yyyy-MM-dd")
	private String fecha;
	
	@NotBlank(message="El email no puede estar vacío")
	@Email(message="El email tiene que ser válido")
		private String email;
	
	@Pattern(regexp ="(|\\+34)[6]([0-9]){8}", message="El número de móvil tiene que ser correcto (solo números pertenecientes a España)")
		private String movil;
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message="La contraseña debe de tener 1 mayúscula, 1 minúscula y 1 número, y mínimo 8 caracteres")
	@NotBlank(message="La contraseña no puede estar vacía")
	  private String password;
	  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getMovil() {
		return fecha;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	  
}
