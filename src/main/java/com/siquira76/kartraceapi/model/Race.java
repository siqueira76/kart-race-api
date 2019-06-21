package com.siquira76.kartraceapi.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Race {
	
	private Integer codPiloto;
	private String nomePiloto;
	private List<Integer> voltas = new ArrayList<>();
	private List<LocalTime> tempo = new ArrayList<>();
	private Integer totalVoltas;
	private Duration tempoCorrida;
	private Integer posicao;
	
	public Race() {
	}
	
	public Integer getCodPiloto() {
		return codPiloto;
	}
	
	public void setCodPiloto(Integer codPiloto) {
		this.codPiloto = codPiloto;
	}
	
	public Race(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public List<Integer> getVoltas() {
		return voltas;
	}

	public void setVoltas(List<Integer> voltas) {
		this.voltas = voltas;
	}

	public List<LocalTime> getTempo() {
		return tempo;
	}

	public void setTempo(List<LocalTime> tempo) {
		this.tempo = tempo;
	}

	public Integer getTotalVoltas() {
		return totalVoltas;
	}

	public void setTotalVoltas(Integer totalVoltas) {
		this.totalVoltas = totalVoltas;
	}

	public Duration getTempoCorrida() {
		return tempoCorrida;
	}

	public void setTempoCorrida(Duration tempoCorrida) {
		this.tempoCorrida = tempoCorrida;
	}
	
	public Integer getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

}
