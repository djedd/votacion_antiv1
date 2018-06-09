package com.votacion_antiv1.votacion_anti.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mandato")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Mandato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mandato;
	
	@Column(name = "abreviacion", nullable = false)
	private String abreviacion;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "fecha_registro", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private Date fecha_creacion;

	public String getAbreviacion() {
		return abreviacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public Integer getId_mandato() {
		return id_mandato;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public void setId_mandato(Integer id_mandato) {
		this.id_mandato = id_mandato;
	}
	
	

}
