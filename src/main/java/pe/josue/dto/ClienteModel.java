package pe.josue.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteModel {
	@NotNull @NotBlank @NotEmpty
	@JsonProperty(required = true)
	String nombre;
	
	@NotNull @NotBlank @NotEmpty
	@JsonProperty(required = true)
	String apellido;
	
	@JsonProperty(required = true)
	int edad;

	@JsonProperty(required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	Date fecNacomiento;
	public ClienteModel(String nombre, String apellido, int edad, Date fecNacomiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fecNacomiento = fecNacomiento;
	}
	public ClienteModel() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFecNacomiento() {
		return fecNacomiento;
	}
	public void setFecNacomiento(Date fecNacomiento) {
		this.fecNacomiento = fecNacomiento;
	}
	
	
}
