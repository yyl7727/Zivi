package com.yyl.Zivi.Dao;

import com.yyl.Zivi.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("select count(p) from Person p where p.loginName=?1")
    Integer checkPerson(String loginName);

    Optional<Person> findPersonByLoginNameAndPassword(String loginName, String password);
}
