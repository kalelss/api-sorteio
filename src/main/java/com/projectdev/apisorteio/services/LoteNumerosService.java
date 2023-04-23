package com.projectdev.apisorteio.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.entities.LoteNumeros;
import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.entities.Usuario;
import com.projectdev.apisorteio.repository.LoteNumerosRepository;
import com.projectdev.apisorteio.repository.NumerosSorteadosRepository;
import com.projectdev.apisorteio.repository.UsuarioRepository;

@Service
public class LoteNumerosService {

	@Autowired
	private LoteNumerosRepository loteNumerosRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private NumerosSorteadosRepository numerosSorteadosRepository;
	
	public String salvar(LoteNumeros loteNumeros) {

		Usuario usuario = usuarioRepository.findById(loteNumeros.getUsuario().getId()).orElseThrow();
		List<Integer> numerosAleatorios = gerarNumeros(loteNumeros.getQtdeTotalDeNumeros());

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
	
	public List<Integer> gerarNumeros(Integer numero){
		List<NumerosSorteados> NumerosSorteados = numerosSorteadosRepository.findAll();
		List<Integer> todosNumeros = IntStream.rangeClosed(1, 99999).boxed().collect(Collectors.toList());

		List<Integer> numerosBancoDeDados = new ArrayList<>();
		Random random = new Random();

		for (NumerosSorteados numeros : NumerosSorteados) {
			numerosBancoDeDados.add(numeros.getNumeros());
		}
		todosNumeros.removeAll(numerosBancoDeDados);
		
		List<Integer> numerosSelecionados = new ArrayList<>(todosNumeros);
		Collections.shuffle(numerosSelecionados, random);
		numerosSelecionados = numerosSelecionados.subList(0, numero);
		return numerosSelecionados;
	}
}
