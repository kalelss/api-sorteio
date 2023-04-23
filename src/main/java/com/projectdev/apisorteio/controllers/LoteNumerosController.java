package com.projectdev.apisorteio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.apisorteio.dto.LoteNumerosDTO;
import com.projectdev.apisorteio.entities.LoteNumeros;
import com.projectdev.apisorteio.repository.LoteNumerosRepository;
import com.projectdev.apisorteio.services.LoteNumerosService;


@RestController
@RequestMapping("/api/lote")
public class LoteNumerosController{
	
	@Autowired
    private LoteNumerosService loteNumerosService;
    
    @Autowired
	private LoteNumerosRepository loteNumerosRepository;
    
	@PostMapping("/adicionar")
	public void adicionar(@RequestBody LoteNumeros loteNumero) {
		loteNumerosService.salvar(loteNumero);
	}

	@GetMapping("/buscartodos")
	public List<LoteNumerosDTO> buscarTodos(){
		List<LoteNumeros> lotes = loteNumerosRepository.findAll();
        List<LoteNumerosDTO> dtos = new ArrayList<>();
        for (LoteNumeros lote : lotes) {
            dtos.add(new LoteNumerosDTO(lote));
        }
		return dtos;
	}
}
