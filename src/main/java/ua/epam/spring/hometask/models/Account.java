package ua.epam.spring.hometask.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "credit")
    private BigDecimal credit;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Long getId() {
        return id;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) &&
                credit.equals(account.credit) &&
                user.equals(account.user) &&
                company.equals(account.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credit, user, company);
    }
}
