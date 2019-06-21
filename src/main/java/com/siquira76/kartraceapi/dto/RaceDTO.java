package com.siquira76.kartraceapi.dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.siquira76.kartraceapi.model.Race;
import com.siquira76.kartraceapi.services.util.UtilService;

public class RaceDTO {
	
	private int posicaoChegada;
	private Integer codPiloto;
	private String nomePiloto;
	private Integer qtdeVoltasCompletadas;
	private LocalTime TempoTotalDeProva;
	
	
	
	public RaceDTO() {
	}

	public RaceDTO(Race raceObj) {
		this.posicaoChegada = raceObj.getPosicao();
		this.codPiloto = raceObj.getCodPiloto();
		this.nomePiloto = raceObj.getNomePiloto();
		this.qtdeVoltasCompletadas = raceObj.getVoltas().size();
		this.TempoTotalDeProva = UtilService.parse(LocalTime.MIDNIGHT.plus(raceObj.getTempoCorrida()).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}

	public int getPosicaoChegada() {
		return posicaoChegada;
	}

	public void setPosicaoChegada(int posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}

	public Integer getCodPiloto() {
		return codPiloto;
	}

	public void setCodPiloto(Integer codPiloto) {
		this.codPiloto = codPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public Integer getQtdeVoltasCompletadas() {
		return qtdeVoltasCompletadas;
	}

	public void setQtdeVoltasCompletadas(Integer qtdeVoltasCompletadas) {
		this.qtdeVoltasCompletadas = qtdeVoltasCompletadas;
	}

	public String getTempoTotalDeProva() {
		return TempoTotalDeProva.toString();
	}

	public void setTempoTotalDeProva(LocalTime tempoTotalDeProva) {
		TempoTotalDeProva = tempoTotalDeProva;
	}

}
