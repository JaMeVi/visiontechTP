package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
}
