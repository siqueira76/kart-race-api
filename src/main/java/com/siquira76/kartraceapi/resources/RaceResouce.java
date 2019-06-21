package com.siquira76.kartraceapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siquira76.kartraceapi.dto.RaceDTO;
import com.siquira76.kartraceapi.services.RaceDTOService;

@RestController
@RequestMapping(value = "/races")
public class RaceResouce {
	
	@Autowired
	RaceDTOService services;
	
	@GetMapping
	public ResponseEntity<List<RaceDTO>> findResult() {
		List<RaceDTO> race = services.findResult();
		return ResponseEntity.ok().body(race);
	}

}
