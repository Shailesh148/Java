package com.example.demo.respository;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonJPARespository extends JpaRepository<PersonEntity,String> {

}
