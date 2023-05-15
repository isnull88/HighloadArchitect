package tr.otus.highLoadArch.service;

import tr.otus.highLoadArch.controller.AuthController;
import tr.otus.highLoadArch.dataLayer.UserRepo;

public class PasswordService {


    private static final String TOKEN = "e4d2e6b0-cde2-42c5-aac3-0b8316f21e58";

    public String checkPassword(String userid, String browserPassword) {
        if (browserPassword == dbPassword) {
            return TOKEN;
        } else {
            return "incorrect password";
        }
    }
}
