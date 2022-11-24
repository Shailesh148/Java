package com.example.demo.respository;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PersonJPARespository extends JpaRepository<PersonEntity,String> {

    List<PersonEntity> findByNameContains(String name);

    List<PersonEntity> findByAge(Integer age);


    @Transactional
    @Modifying
    @Query("Update PersonEntity p set p.age=?1 where p.name=?2")
    int updateQueryExample(Integer age, String name);


    @Transactional
    @Modifying
    @Query("Update PersonEntity p set p.age= :ageValue where p.name= :nameValue")
    int updateQueryExample2(@Param("ageValue") Integer age, @Param("nameValue") String name);

}
