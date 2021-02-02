package com.backend.demo.repository;


import com.backend.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query("select c from Event c where c.e_id <= :number")
    List<Event> findAllBy(@Param("number") Long number);

    @Query("select c from Event c where c.e_id >= :n1 and c.e_id <= :n2")
    List<Event> findAllBetween(@Param("n1") Long n1, @Param("n2") Long n2);

}
