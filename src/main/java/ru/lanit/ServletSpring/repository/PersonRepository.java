package ru.lanit.ServletSpring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.ServletSpring.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
