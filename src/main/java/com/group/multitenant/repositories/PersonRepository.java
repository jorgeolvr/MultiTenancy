package com.group.multitenant.repositories;

import com.group.multitenant.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}