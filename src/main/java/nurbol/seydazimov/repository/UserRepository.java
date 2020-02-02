package nurbol.seydazimov.repository;

import nurbol.seydazimov.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
