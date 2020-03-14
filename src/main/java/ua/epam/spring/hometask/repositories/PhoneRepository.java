package ua.epam.spring.hometask.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.epam.spring.hometask.models.Phone;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
