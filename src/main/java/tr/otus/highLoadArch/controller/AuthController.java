package tr.otus.highLoadArch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.otus.highLoadArch.controller.dto.request.LoginRequest;
import tr.otus.highLoadArch.dataLayer.UserRepo;
import tr.otus.highLoadArch.model.User;
import tr.otus.highLoadArch.service.PasswordService;

@RestController
    @RequestMapping(path = "/login")

    public class AuthController {
        private final UserRepo userRepo;

    private final PasswordService passwordService;

        @Autowired
        public AuthController(UserRepo userRepo) {
            this.userRepo = userRepo;
        }


        @PostMapping
        public User login(@RequestBody()LoginRequest loginRequest) {
            return passwordService.;
        }



    }









