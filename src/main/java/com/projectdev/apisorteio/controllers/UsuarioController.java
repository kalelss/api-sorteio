package com.projectdev.apisorteio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdev.apisorteio.dto.UsuarioDTO;
import com.projectdev.apisorteio.entities.Usuario;
import com.projectdev.apisorteio.repository.UsuarioRepository;
import com.projectdev.apisorteio.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@PostMapping("/adicionar")
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioService.adicionar(usuario);
	}
	
	@GetMapping("/buscartodos")
	public List<UsuarioDTO> buscarTodos(){
		return usuarioService.buscarTodos();
	}
}
