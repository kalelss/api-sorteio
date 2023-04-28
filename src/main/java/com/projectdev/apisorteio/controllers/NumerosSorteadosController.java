package com.projectdev.apisorteio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.apisorteio.dto.NumeroSorteadoDTO;
import com.projectdev.apisorteio.services.NumerosSorteadosService;

@RestController
@RequestMapping("/api/numeros")
public class NumerosSorteadosController{

	@Autowired
	private NumerosSorteadosService numerosSorteadosService;
	
	@GetMapping("/buscartodos")
	public List<NumeroSorteadoDTO> buscarTodos(){
		return numerosSorteadosService.buscarTodos();
	}
}
