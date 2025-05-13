package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.CondicionAtmosferica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CondicionAtmosfericaRepository extends JpaRepository<CondicionAtmosferica, Integer> {

    @Query("SELECT ca FROM CondicionAtmosferica ca " +
            "WHERE LOWER(TRIM(ca.ruta.nombreRuta)) = LOWER(TRIM(:nombreRuta)) " +
            "AND ca.fechaHora BETWEEN :fechaInicio AND :fechaFin")
    List<CondicionAtmosferica> findByNombreRutaAndFechaHoraBetween(
            @Param("nombreRuta") String nombreRuta,
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin
    );

  /*  @Query(
            value = """
        SELECT ca.*
        FROM condiciones_atmosfericas ca
        JOIN rutas r ON ca.id_ruta = r.id_ruta
        WHERE LOWER(TRIM(r.nombre_ruta)) = LOWER(TRIM(:nombreRuta))
        AND ca.fecha_hora BETWEEN :fechaInicio AND :fechaFin
        """,
            nativeQuery = true
    )
    List<CondicionAtmosferica> findByNombreRutaAndFechaHoraBetween(
            @Param("nombreRuta") String nombreRuta,
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin
    );
*/

    @Query("SELECT c FROM CondicionAtmosferica c WHERE LOWER(TRIM(c.ruta.nombreRuta)) = LOWER(TRIM(:nombreRuta)) " +
            "ORDER BY c.fechaHora DESC LIMIT 1")
    Optional<CondicionAtmosferica> findUltimaByNombreRuta(@Param("nombreRuta") String nombreRuta);
}