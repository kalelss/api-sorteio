package com.projectdev.apisorteio.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.repository.NumerosSorteadosRepository;

@Service
public class GerarNumerosAleatorios {
	@Autowired
	private NumerosSorteadosRepository numerosSorteadosRepository;
	
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
