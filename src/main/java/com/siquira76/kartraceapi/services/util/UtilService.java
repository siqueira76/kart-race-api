package com.siquira76.kartraceapi.services.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public static Race voltaPilotoFactory(List<Linha> linhas, String piloto) {
		Race volta = new Race();
		for (Linha linha : linhas) {
			if (linha.getNomePiloto().contains(piloto)) {
				volta.setCodPiloto(Integer.parseInt(linha.getNumeroPiloto()));
				volta.setNomePiloto(linha.getNomePiloto());
				volta.getVoltas().add(linha.getNumeroVolta());
				volta.getTempo().add(linha.getHora());
			}
		}
		volta.setTotalVoltas(volta.getVoltas().size());
		volta.setTempoCorrida(
				Duration.between(volta.getTempo().get(0), volta.getTempo().get(volta.getTempo().size() - 1)));
		return volta;
	}

	public static List<Race> voltasFactory(List<Linha> linhas) {
		Set<String> pilotos = new HashSet<>();
		List<Race> voltaPilotos = new ArrayList<>();
		linhas.forEach(l -> pilotos.add(l.getNomePiloto()));
		for (String piloto : pilotos) {
			voltaPilotos.add(UtilService.voltaPilotoFactory(linhas, piloto));
		}
		voltaPilotos.forEach(v -> v.setPosicao(voltaPilotos.indexOf(v)+1));
		return voltaPilotos;
	}

}
