package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.com.visiontech2.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
