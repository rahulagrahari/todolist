package com.deloitte.todoApplication.todolistapplication.todoitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface todoitemRepository extends JpaRepository<todoitem, Integer> {

    List<todoitem> findByToDoListUser(String userName);


}
