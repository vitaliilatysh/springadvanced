package ua.epam.spring.hometask.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return name;
    }

}
