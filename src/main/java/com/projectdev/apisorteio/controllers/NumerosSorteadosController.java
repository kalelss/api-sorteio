package com.projectdev.apisorteio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.apisorteio.dto.NumeroSorteadoDTO;
import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.repository.NumerosSorteadosRepository;

@RestController
@RequestMapping("/api/numeros")
public class NumerosSorteadosController{

	@Autowired
	private NumerosSorteadosRepository numerosSorteadosRepository;
	
	@GetMapping("/buscartodos")
	public List<NumeroSorteadoDTO> buscarTodos(){
		List<NumerosSorteados> lotes = numerosSorteadosRepository.findAll();
        List<NumeroSorteadoDTO> dtos = new ArrayList<>();
        for (NumerosSorteados lote : lotes) {
            dtos.add(new NumeroSorteadoDTO(lote));
        }
		return dtos;
	}
}
