package ua.epam.spring.hometask.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vitalii Latysh
 * Created: 12.03.2020
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id.equals(phone.id) &&
                number.equals(phone.number) &&
                user.equals(phone.user) &&
                company.equals(phone.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, user, company);
    }
}
