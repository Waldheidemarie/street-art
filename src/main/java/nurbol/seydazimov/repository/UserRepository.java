package nurbol.seydazimov.repository;

import nurbol.seydazimov.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
