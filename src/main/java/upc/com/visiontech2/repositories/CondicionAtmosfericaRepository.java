package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.CondicionAtmosferica;

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
