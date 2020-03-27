package ua.epam.spring.hometask.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.epam.spring.hometask.models.Account;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
