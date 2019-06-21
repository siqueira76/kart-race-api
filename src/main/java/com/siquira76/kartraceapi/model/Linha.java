package com.siquira76.kartraceapi.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Linha implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private LocalTime hora;
	private String codPiloto;
	private String nomePiloto;
	private int numeroVolta;
	private LocalTime tempoVolta;
	private Double velocidadeMediaVolta;

	public Linha() {
	}

	public Linha(int id, LocalTime hora, String codPiloto, String nomePiloto, int numeroVolta, LocalTime tempoVolta,
			Double velocidadeMediaVolta) {
		this.id = id;
		this.hora = hora;
		this.codPiloto = codPiloto;
		this.nomePiloto = nomePiloto;
		this.numeroVolta = numeroVolta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getNumeroPiloto() {
		return codPiloto;
	}

	public void setCodPiloto(String codPiloto) {
		this.codPiloto = codPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public int getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(int numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(LocalTime tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public Double getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	public void setVelocidadeMediaVolta(Double velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linha other = (Linha) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
