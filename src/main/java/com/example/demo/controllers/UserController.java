package com.example.demo.controllers;

import com.example.demo.model.MyUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class UserController {
    ArrayList<MyUser> users = new ArrayList<>();


// @RequestMapping(method = RequestMethod.GET,path = "users")
   @GetMapping("users")
    public ArrayList<MyUser> GetUser(){
        System.out.println("Hay from get users");
        return users;
    }


// @RequestMapping(method = RequestMethod.POST,path = "users")
@PostMapping("users")
    public ArrayList<MyUser> PostUser(@RequestBody MyUser user ){
     users.add(user);
      System.out.println("Hay from POST users");
        return users;
    }
// @RequestMapping(method = RequestMethod.DELETE,path = "users/{index}")
    @DeleteMapping("users/{index}")
    public ArrayList<MyUser> DeleteUser(@PathVariable int index ){
        users.remove(index);
        System.out.println("hay from delete users");
        return users;
    }


// @RequestMapping(method = RequestMethod.PUT,path = "users/{index}")
    @PutMapping("users/{index}")
    public ArrayList<MyUser> UpdateUsers(@PathVariable int index, @RequestBody MyUser userName){
        users.set(index,userName);
        System.out.println("hay from delete users");
        return users;
    }

}
