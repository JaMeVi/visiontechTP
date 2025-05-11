package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.com.visiontech2.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
