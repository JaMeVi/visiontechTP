package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.TemaForo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TemaForoRepository extends JpaRepository<TemaForo, Integer> {
    // 1. Temas creados después de una fecha
    @Query("SELECT t FROM TemaForo t WHERE t.fechaCreacion > :fecha")
    List<TemaForo> TemasDespuesDeFecha(@Param("fecha") LocalDate fecha);

    // 2. Temas cerrados
    @Query("SELECT t FROM TemaForo t WHERE t.estadoCerrado = true")
    List<TemaForo> TemasCerrados();

    // 4. Temas por usuario
    @Query("SELECT t FROM TemaForo t WHERE t.usuario.id = :idUsuario")
    List<TemaForo> TemasPorUsuario(@Param("idUsuario") int idUsuario);


}
