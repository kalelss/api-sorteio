package com.projectdev.apisorteio.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-numerossorteados")
public class NumerosSorteados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_numeros_id")
    private LoteNumeros loteNumeros;
    
    private Integer numeros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LoteNumeros getLoteNumeros() {
		return loteNumeros;
	}

	public void setLoteNumeros(LoteNumeros loteNumeros) {
		this.loteNumeros = loteNumeros;
	}

	public Integer getNumeros() {
		return numeros;
	}

	public void setNumeros(Integer numeros) {
		this.numeros = numeros;
	}
}
