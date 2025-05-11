package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Metrica;

import java.util.List;

@Repository
public interface MetricaRepository extends JpaRepository<Metrica,Integer> {

    @Query("SELECT m FROM Metrica m JOIN m.ruta r WHERE LOWER(r.nombreRuta) LIKE LOWER(concat('%', :nombreRuta, '%'))")
    List<Metrica> findByNombreRutaContaining(@Param("nombreRuta") String nombreRuta);
}
