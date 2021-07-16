package com.group.multitenant.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import com.group.multitenant.entities.Person;
import com.group.multitenant.repositories.PersonRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
  private final PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  // Lista todos as pessoas
  @GetMapping
  public List<Person> get() {
    return personRepository.findAll();
  }

  // Lista uma determinada pessoa
  @GetMapping("{id}")
  public Optional<Person> get(@PathVariable("id") Long id) {
    return personRepository.findById(id);
  }

  // Inclui uma nova pessoa
  @PostMapping
  public Person persist(@RequestParam("name") String name) {
    return personRepository.save(new Person(name));
  }

  // Altera uma determinada pessoa
  @PutMapping("{id}")
  public Person update(@PathVariable("id") Long id, @RequestParam("name") String name) {
    var person = personRepository.findById(id).map(p -> p.setName(name)).orElseThrow(NoResultException::new);
    return personRepository.save(person);
  }

  // Deleta uma determinada pessoa
  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Long id) {
    personRepository.deleteById(id);
  }

}
