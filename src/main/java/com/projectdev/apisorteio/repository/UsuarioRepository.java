package com.projectdev.apisorteio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectdev.apisorteio.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
