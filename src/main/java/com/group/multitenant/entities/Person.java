package com.group.multitenant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    public Person() {
    }

    public Person(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        return this;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
