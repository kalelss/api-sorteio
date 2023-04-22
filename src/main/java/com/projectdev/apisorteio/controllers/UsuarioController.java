package com.projectdev.apisorteio.controllers;

import java.io.Serializable;
import java.util.ArrayList;
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
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@PostMapping("/adicionar")
	public void adicionar(@RequestBody Usuario usuario) {
		usuarioService.adicionar(usuario);
	}
	
	@GetMapping("/buscartodos")
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> lotes = usuarioRepository.findAll();
        List<UsuarioDTO> dtos = new ArrayList<>();
        for (Usuario lote : lotes) {
            dtos.add(new UsuarioDTO(lote));
        }
        return dtos;
	}
}
