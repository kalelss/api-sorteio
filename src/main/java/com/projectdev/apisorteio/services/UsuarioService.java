package com.projectdev.apisorteio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.entities.Usuario;
import com.projectdev.apisorteio.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario adicionar(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}
}
