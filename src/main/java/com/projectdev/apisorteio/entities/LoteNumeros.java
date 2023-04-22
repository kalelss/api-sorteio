package com.projectdev.apisorteio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-lotenumeros")
public class LoteNumeros implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    private Double precoPorNumero;
    private Integer qtdeTotalDeNumeros;
    private Double precoTotal;
    
    @OneToMany(mappedBy = "loteNumeros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NumerosSorteados> numerosSorteados = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public List<NumerosSorteados> getNumerosSorteados() {
		return numerosSorteados;
	}

	public void setNumerosSorteados(List<NumerosSorteados> numerosSorteados) {
		this.numerosSorteados = numerosSorteados;
	}
	
	public Double somaPrecoTotal(Double precoPorNumero, Integer qtdeTotalDeNumeros) {
		return precoPorNumero * qtdeTotalDeNumeros;
	}
}
