package ua.epam.spring.hometask.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.epam.spring.hometask.models.User;

import java.util.Optional;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String username);
}
