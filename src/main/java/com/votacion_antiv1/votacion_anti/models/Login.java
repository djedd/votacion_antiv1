package com.votacion_antiv1.votacion_anti.models;

public class Login {

	private Integer identificacion;
	private String contrasena;

	public String getContrasena() {
		return contrasena;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

}
