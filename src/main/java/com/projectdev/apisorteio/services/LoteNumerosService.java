package com.projectdev.apisorteio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.entities.LoteNumeros;
import com.projectdev.apisorteio.entities.NumerosSorteados;
import com.projectdev.apisorteio.entities.Usuario;
import com.projectdev.apisorteio.repository.LoteNumerosRepository;
import com.projectdev.apisorteio.repository.UsuarioRepository;

@Service
public class LoteNumerosService {


	@Autowired
    private LoteNumerosRepository loteNumerosRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public LoteNumeros salvar(LoteNumeros loteNumeros) {
    	Usuario usuario = usuarioRepository.findById(loteNumeros.getUsuario().getId()).orElseThrow();
    	
    	loteNumeros.setUsuario(usuario);
    	loteNumeros.setPrecoTotal(loteNumeros.somaPrecoTotal(loteNumeros.getPrecoPorNumero(), loteNumeros.getQtdeTotalDeNumeros()));
        for (Integer i = 1; i <= loteNumeros.getQtdeTotalDeNumeros(); i++) {
            NumerosSorteados numerosSorteados = new NumerosSorteados();
            numerosSorteados.setLoteNumeros(loteNumeros);
            numerosSorteados.setNumeros(i);
            loteNumeros.getNumerosSorteados().add(numerosSorteados);
        }
        return loteNumerosRepository.save(loteNumeros);
    }
}
