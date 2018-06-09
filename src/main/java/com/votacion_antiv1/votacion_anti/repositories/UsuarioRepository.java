package com.votacion_antiv1.votacion_anti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votacion_antiv1.votacion_anti.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByIdentificacion(Integer identificacion);

}
