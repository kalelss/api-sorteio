package com.projectdev.apisorteio.dto;

import com.projectdev.apisorteio.entities.NumerosSorteados;

public class NumeroSorteadoDTO {
	
    private Long id;
    private Long loteNumerosId;
    private Integer numeros;
    
    public NumeroSorteadoDTO(NumerosSorteados numerosSorteados) {
    	this.id = numerosSorteados.getId();
    	this.loteNumerosId = numerosSorteados.getLoteNumeros().getId();
    	this.numeros = numerosSorteados.getNumeros();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoteNumerosId() {
		return loteNumerosId;
	}

	public void setLoteNumerosId(Long loteNumerosId) {
		this.loteNumerosId = loteNumerosId;
	}

	public Integer getNumeros() {
		return numeros;
	}

	public void setNumeros(Integer numeros) {
		this.numeros = numeros;
	}
    
}
