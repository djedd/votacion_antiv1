package com.votacion_antiv1.votacion_anti.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="voto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_voto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jugador")
	private Mandato mandato;

	public Integer getId_voto() {
		return id_voto;
	}

	public Mandato getMandato() {
		return mandato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId_voto(Integer id_voto) {
		this.id_voto = id_voto;
	}

	public void setMandato(Mandato mandato) {
		this.mandato = mandato;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
