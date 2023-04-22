package com.projectdev.apisorteio.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projectdev.apisorteio.entities.LoteNumeros;
import com.projectdev.apisorteio.entities.NumerosSorteados;

public class LoteNumerosDTO {
    private Long id;
    private Double precoPorNumero;
    private Integer qtdeTotalDeNumeros;
    private Double precoTotal;
    private Long usuarioId;
    private List<Integer> numerosSorteados;
    
    public LoteNumerosDTO(LoteNumeros loteNumeros) {
        this.id = loteNumeros.getId();
        this.numerosSorteados = loteNumeros.getNumerosSorteados().stream()
                .map(NumerosSorteados::getNumeros)
                .collect(Collectors.toList());
        this.precoPorNumero = loteNumeros.getPrecoPorNumero();
        this.qtdeTotalDeNumeros = loteNumeros.getQtdeTotalDeNumeros();
        this.precoTotal = loteNumeros.getPrecoTotal();
        this.usuarioId = loteNumeros.getUsuario().getId();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Integer> getNumerosSorteados() {
		return numerosSorteados;
	}

	public void setNumerosSorteados(List<Integer> numerosSorteados) {
		this.numerosSorteados = numerosSorteados;
	}

	public Double getPrecoPorNumero() {
		return precoPorNumero;
	}

	public void setPrecoPorNumero(Double precoPorNumero) {
		this.precoPorNumero = precoPorNumero;
	}

	public Integer getQtdeTotalDeNumeros() {
		return qtdeTotalDeNumeros;
	}

	public void setQtdeTotalDeNumeros(Integer qtdeTotalDeNumeros) {
		this.qtdeTotalDeNumeros = qtdeTotalDeNumeros;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
    
}
