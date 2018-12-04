package com.deloitte.todoApplication.todolistapplication.todoitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
public class todoitemController {

    @Autowired
    todoitemService itemService;

    @RequestMapping(method= RequestMethod.GET, value="/api/todo/allitems")
    public List<todoitem> getAllItems(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        return itemService.getAllitem(principal.getName());

    }

    @RequestMapping(method=RequestMethod.POST, value="/api/todo/add")
    public String addItem(@RequestBody todoitem item, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        itemService.addItem(item, principal.getName());
        return "{\"status\" : \"ok\"}";
    }




}
