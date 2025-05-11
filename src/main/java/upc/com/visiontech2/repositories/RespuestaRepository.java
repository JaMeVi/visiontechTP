package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Respuesta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    // 1. Respuestas después de una fecha
    @Query("SELECT r FROM Respuesta r WHERE r.fechaRespuesta > :fecha")
    List<Respuesta> RespuestasDespuesDeFecha(@Param("fecha") LocalDate fecha);

    // 2. Cantidad de respuestas por cada tema
    @Query("SELECT r.temaForo.tituloTema, COUNT(r) FROM Respuesta r GROUP BY r.temaForo.tituloTema")
    List<Object[]> RespuestasPorTema();

    // 3. Top 3 temas con más respuestas
    @Query("SELECT r.temaForo.tituloTema, COUNT(r) as total FROM Respuesta r GROUP BY r.temaForo.tituloTema ORDER BY total DESC")
    List<Object[]> TemasPorCantidadDeRespuestas();

    // 4. Obtener respuestas por tema específico
    @Query("SELECT r FROM Respuesta r WHERE r.temaForo.idTema = :idTema")
    List<Respuesta> RespuestasPorTema(@Param("idTema") int idTema);
}
