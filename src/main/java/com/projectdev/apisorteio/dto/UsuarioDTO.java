package com.projectdev.apisorteio.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projectdev.apisorteio.entities.Usuario;

public class UsuarioDTO {
	
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    
    private List<LoteNumerosDTO> loteNumeros = new ArrayList<>();

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.telefone = usuario.getTelefone();
		this.cpf = usuario.getCpf();
		this.loteNumeros = usuario.getLoteNumeros().stream().map(LoteNumerosDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<LoteNumerosDTO> getLoteNumeros() {
		return loteNumeros;
	}

	public void setLoteNumeros(List<LoteNumerosDTO> loteNumeros) {
		this.loteNumeros = loteNumeros;
	}

}
