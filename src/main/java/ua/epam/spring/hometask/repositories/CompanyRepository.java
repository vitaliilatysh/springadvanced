package ua.epam.spring.hometask.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.epam.spring.hometask.models.Company;

import java.util.Optional;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    Optional<Company> findByName(String name);
}
