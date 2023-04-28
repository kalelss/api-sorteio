package com.projectdev.apisorteio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.dto.NumeroSorteadoDTO;
import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.repository.NumerosSorteadosRepository;

@Service
public class NumerosSorteadosService {
	
	@Autowired
	private NumerosSorteadosRepository numerosSorteadosRepository;
	
	public List<NumeroSorteadoDTO> buscarTodos(){
		List<NumerosSorteados> lotes = numerosSorteadosRepository.findAll();
        List<NumeroSorteadoDTO> dtos = new ArrayList<>();
        for (NumerosSorteados lote : lotes) {
            dtos.add(new NumeroSorteadoDTO(lote));
        }
		return dtos;
	}
}
