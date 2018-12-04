package com.deloitte.todoApplication.todolistapplication.authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class AuthenticationController {

    @Autowired
    CustomUserDetailService customUserDetailService;
    @RequestMapping(method = RequestMethod.GET, value = "/api/todo/login")
    public String login( ) {

//        String username = userDetails.getUsername();
//        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        authorities
//                .forEach(System.out::println);

        return "Hello World";
    }
    @RequestMapping(method = RequestMethod.POST, value="/register")
    public void addUser(@RequestBody User user){

        customUserDetailService.addNewUser(user);
    }


}
