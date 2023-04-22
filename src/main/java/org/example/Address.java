package org.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    int id;
    String city;
    String state;
    String country;
    @ManyToOne
    Student student;

    public Address(int id, String city, String state, String country) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {
    }
}
