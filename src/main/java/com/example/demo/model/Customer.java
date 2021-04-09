package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Customer {
    private Long id;
    private String fullName;
    private String SalesRepresentativeName;
    private Long age;

    public Customer() {
    }

    public Customer(Long id, String fullName, String salesRepresentativeName, Long age) {
        this.id = id;
        this.fullName = fullName;
        SalesRepresentativeName = salesRepresentativeName;
        this.age = age;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSalesRepresentativeName() {
        return SalesRepresentativeName;
    }

    public void setSalesRepresentativeName(String salesRepresentativeName) {
        SalesRepresentativeName = salesRepresentativeName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
