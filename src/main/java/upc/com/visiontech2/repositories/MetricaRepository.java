package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Metrica;

import java.util.List;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica,Integer> {

    @Query("SELECT m FROM Metrica m JOIN m.ruta r WHERE LOWER(r.nombreRuta) = LOWER(:nombreRuta)")
    List<Metrica> findByNombreRutaContaining(@Param("nombreRuta") String nombreRuta);


    @Query("SELECT COALESCE(SUM(m.caloriasQuemadas), 0) " +
            "FROM Metrica m " +
            "WHERE LOWER(TRIM(m.ruta.nombreRuta)) = LOWER(TRIM(:nombreRuta))")
    int sumCaloriasByNombreRuta(@Param("nombreRuta") String nombreRuta);


  /* //SQL
  @Query(
            value = """
    SELECT SUM(m.caloria_quemadas) FROM metricas m
            JOIN rutas r ON m.id_ruta = r.id_ruta
    WHERE LOWER(TRIM(r.nombre_ruta)) = LOWER(TRIM(:nombreRuta))
    """,
            nativeQuery = true
    )
    Integer sumCaloriasByNombreRuta(@Param("nombreRuta") String nombreRuta);*/
}
