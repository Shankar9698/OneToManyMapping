package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "sId")
    int id;
    @Column(name = "sName")
    String name;
    @OneToMany
    List<Address> addressList;

    public Student(int id, String name, List<Address> addressList) {
        this.id = id;
        this.name = name;
        this.addressList = addressList;
    }

    public Student() {

    }
}
