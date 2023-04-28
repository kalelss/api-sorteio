package com.projectdev.apisorteio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.dto.LoteNumerosDTO;
import com.projectdev.apisorteio.entities.LoteNumeros;
import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.entities.Usuario;
import com.projectdev.apisorteio.repository.LoteNumerosRepository;
import com.projectdev.apisorteio.repository.UsuarioRepository;
import com.projectdev.apisorteio.util.GerarNumerosAleatorios;

@Service
public class LoteNumerosService {

	@Autowired
	private LoteNumerosRepository loteNumerosRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GerarNumerosAleatorios gerarNumerosAleatorios;
	
	public String salvar(LoteNumeros loteNumeros) {

		Usuario usuario = usuarioRepository.findById(loteNumeros.getUsuario().getId()).orElseThrow();
		List<Integer> numerosAleatorios = gerarNumerosAleatorios.gerarNumeros(loteNumeros.getQtdeTotalDeNumeros());

		loteNumeros.setUsuario(usuario);
		loteNumeros.setPrecoTotal(
				loteNumeros.somaPrecoTotal(loteNumeros.getPrecoPorNumero(), loteNumeros.getQtdeTotalDeNumeros()));

		for (Integer numeros : numerosAleatorios) {
			NumerosSorteados numerosSorteados = new NumerosSorteados();
			numerosSorteados.setLoteNumeros(loteNumeros);
			numerosSorteados.setNumeros(numeros);
			loteNumeros.getNumerosSorteados().add(numerosSorteados);
		}

		loteNumerosRepository.save(loteNumeros);
		return "Lote criado com sucesso!";
	}
	
	public List<LoteNumerosDTO> buscarTodos(){
		List<LoteNumeros> lotes = loteNumerosRepository.findAll();
        List<LoteNumerosDTO> dtos = new ArrayList<>();
        for (LoteNumeros lote : lotes) {
            dtos.add(new LoteNumerosDTO(lote));
        }
		return dtos;
	}
}
