package com.siquira76.kartraceapi.services.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.siquira76.kartraceapi.model.Linha;
import com.siquira76.kartraceapi.model.Race;

public class UtilService {
	
	public static List<String> fileReader(String filePath) {
		String line = null;
		List<String> strings = new ArrayList<>();
		try (FileReader reader = new FileReader(filePath); BufferedReader br = new BufferedReader(reader)) {
			
			while ((line = br.readLine()) != null) {
				strings.addAll(Arrays.asList(line));
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return strings;
	}

	public static List<Linha> linhas(List<String> strings) {
		List<String> linhas = new ArrayList<>();
		List<Linha> linhas1 = new ArrayList<>();
		for (int i = 1; i < strings.size(); i++) {
			String[] linha = ((String) strings.get(i)).replaceAll("\\s+", "-").split("-");
			linhas.addAll(Arrays.asList(linha[0], linha[1], linha[3], linha[4], linha[5], linha[6]));
			linhas1.add(new Linha(i, UtilService.parse(linha[0]), linha[1], linha[3], Integer.parseInt(linha[4]),
					UtilService.parse("00:0" + linha[5]), Double.parseDouble(linha[6].replace(",", ".").toString())));
		}
		return linhas1;
	}

	public static LocalTime parse(String str) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		return LocalTime.parse(str, dateTimeFormatter);
	}

	public static Race raceFactory(List<Linha> linhas, String piloto) {
		Race race = new Race();
		for (Linha linha : linhas) {
			if (linha.getNomePiloto().contains(piloto)) {
				race.setCodPiloto(Integer.parseInt(linha.getNumeroPiloto()));
				race.setNomePiloto(linha.getNomePiloto());
				race.getVoltas().add(linha.getNumeroVolta());
				race.getTempo().add(linha.getHora());
				race.getTempoVoltas().add(linha.getVelocidadeMediaVolta());
			}
		}
		race.setTotalVoltas(race.getVoltas().size());
		race.setTempoCorrida(
				Duration.between(race.getTempo().get(0), race.getTempo().get(race.getTempo().size() - 1)));
		return race;
	}

	public static List<Race> setRaceList(List<Linha> linhas) {
		Set<String> pilotos = new HashSet<>();
		List<Race> raceList = new ArrayList<>();
		linhas.forEach(l -> pilotos.add(l.getNomePiloto()));
		for (String piloto : pilotos) {
			raceList.add(UtilService.raceFactory(linhas, piloto));
		}
		raceList.forEach(v -> v.setPosicao(raceList.indexOf(v)+1));
		return raceList;
	}
	
	public static Double mimDouble(List<Double> list) {
		DoubleSummaryStatistics summary = list.stream().collect(Collectors.summarizingDouble(Double::doubleValue));
		return summary.getMin();
	}

}
