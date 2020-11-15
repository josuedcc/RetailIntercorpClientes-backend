package pe.josue.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDto extends ClienteModel {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	Date fechaMuerte;
	String idClient;
	public Date getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public ClienteDto(String nombre, String apellido, int edad, Date fecNacomiento, Date fechaMuerte, String idClient) {
		super(nombre, apellido, edad, fecNacomiento);
		this.fechaMuerte = fechaMuerte;
		this.idClient = idClient;
	}

	public ClienteDto() {
	}
}
