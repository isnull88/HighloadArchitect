package tr.otus.highLoadArch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.otus.highLoadArch.dataLayer.UserRepo;
import tr.otus.highLoadArch.model.User;

import java.util.List;

@RestController
@RequestMapping(path = "/user")

public class UserController {
    private final UserRepo userRepo;


    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/get/{id}")
    public User getUser(@PathVariable(name = "id") String id) {
        return userRepo.getUsersByID(id);
    }

    @GetMapping("/search")
    public List<User> getUserSearch(@RequestParam(name ="first_name") String first_name,
                                    @RequestParam(name ="last_name") String last_name) {
        return userRepo.getUserByName(first_name, last_name);
        }


    }







