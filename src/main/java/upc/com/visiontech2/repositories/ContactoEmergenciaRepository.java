package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.ContactoEmergencia;

import java.util.List;

@Repository
public interface ContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia, Integer> {
    List<ContactoEmergencia> findByNombreContainingIgnoreCase(String nombre);
}
