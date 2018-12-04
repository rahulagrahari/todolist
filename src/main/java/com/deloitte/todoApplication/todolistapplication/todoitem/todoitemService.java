package com.deloitte.todoApplication.todolistapplication.todoitem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoitemService {

    @Autowired
    todoitemRepository repo;


    public List<todoitem> getAllitem(String userName) {
        System.out.println(userName+"----------------");
//        List<todoitem> item = new ArrayList<todoitem>();
//        repo.findAll().forEach(s -> item.add((todoitem) s));

        return repo.findByToDoListUser(userName);

    }


    public void addItem(todoitem item, String userName) {

        todoitem itm = new todoitem();
        itm.setDesc(item.getDesc());
        itm.setToDoListUser(userName);
        itm = repo.save(itm);

    }
    
    public void test() {
    	System.out.println("\n \n \n this is from the heart \n \n \n \n");
    }

}
