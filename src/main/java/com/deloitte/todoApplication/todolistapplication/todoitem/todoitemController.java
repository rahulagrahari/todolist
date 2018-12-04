package com.deloitte.todoApplication.todolistapplication.todoitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class todoitemController {

    @Autowired
    private todoitemService itemService;

//    @RequestMapping(method= RequestMethod.GET, value="/api/todo/allitems")
    @GetMapping(value = "/allitems")
    public List<todoitem> getAllItems(HttpServletRequest request){
    	
        Principal principal = request.getUserPrincipal();
         
        if (principal==null) {
        	throw new UsernameNotFoundException("Unauthorized Request");
        }
        else {
        	 List<todoitem> l = itemService.getAllitem(principal.getName().toString());
             return l;
        }
       

    }

//    @RequestMapping(method=RequestMethod.POST, value="/api/todo/add")
    @PostMapping(value = "/add")
    public String addItem(@RequestBody todoitem item, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        itemService.addItem(item, principal.getName());
        return "{\"status\" : \"ok\"}";
    }




}
