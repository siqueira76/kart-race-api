package com.siquira76.kartraceapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.siquira76.kartraceapi.dto.RaceDTO;
import com.siquira76.kartraceapi.model.Linha;
import com.siquira76.kartraceapi.model.Race;
import com.siquira76.kartraceapi.services.util.UtilService;

@Service
public class RaceDTOService {
	
	public List<RaceDTO> findResult(){
		List<String> strings = new ArrayList<>();
		strings = UtilService.fileReader("./race.txt");
		List<Linha> linhas = UtilService.linhas(strings);
		List<Race> raceList = UtilService.voltasFactory(linhas);
		List<RaceDTO> dto = new ArrayList<>();
		raceList.forEach(v -> dto.add(new RaceDTO(v)));
		dto.sort(Comparator.comparingInt(v -> ( ((RaceDTO) v).getQtdeVoltasCompletadas()))
				.reversed()
				.thenComparing(v -> ((RaceDTO) v).getTempoTotalDeProva()));
		dto.forEach(v -> v.setPosicaoChegada(dto.indexOf(v)+1));
		return dto;
	}

}
