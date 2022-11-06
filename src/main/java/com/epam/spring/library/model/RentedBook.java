package com.epam.spring.library.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Component
@Entity
@Table(name = "book_user")
public class RentedBook {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @OneToOne
    private Book book;
    @OneToOne
    private User user;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "status_pay")
    private StatusPayRentedBook status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RentedBook that = (RentedBook) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
