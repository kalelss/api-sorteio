package com.projectdev.apisorteio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectdev.apisorteio.dto.UsuarioDTO;
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
	
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> lotes = usuarioRepository.findAll();
        List<UsuarioDTO> dtos = new ArrayList<>();
        for (Usuario lote : lotes) {
            dtos.add(new UsuarioDTO(lote));
        }
        return dtos;
	}
}
