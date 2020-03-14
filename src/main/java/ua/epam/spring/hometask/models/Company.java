package ua.epam.spring.hometask.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Phone> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id.equals(company.id) &&
                name.equals(company.name) &&
                phones.equals(company.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phones);
    }
}
