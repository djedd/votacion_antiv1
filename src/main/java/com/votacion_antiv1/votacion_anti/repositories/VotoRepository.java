package com.votacion_antiv1.votacion_anti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.votacion_antiv1.votacion_anti.models.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
	
	@Query(value = "SELECT * FROM voto WHERE id_jugador = :id_jugador", nativeQuery = true)
    public List<Voto> votosJugador(@Param("id_jugador") Integer id_jugador);
	
	
	@Query(value = "SELECT COUNT(*) FROM voto WHERE id_jugador = :id_jugador", nativeQuery = true)
    public Integer numVotosJugador(@Param("id_jugador") Integer id_jugador);

}
