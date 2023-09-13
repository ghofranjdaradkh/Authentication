package com.ghofranjdaradkh.AuthenticationSite.controller;

import com.ghofranjdaradkh.AuthenticationSite.Repository.AuthenticationRepository;
import com.ghofranjdaradkh.AuthenticationSite.models.SiteUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthenticationController {


    @Autowired
    AuthenticationRepository AuthenticationRepository;

@GetMapping ("/")
public String homePage(){
    return "index";
}
    @GetMapping("/login")
    public String getLogin(){
        return "login.html";
    }
    @GetMapping("/signup")
    public String getSignUp(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(String username , String password) {
    String hashedPassword= BCrypt.hashpw(password,BCrypt.gensalt(14));
        SiteUser siteUser = new SiteUser(username, hashedPassword);
        AuthenticationRepository.save(siteUser);
        System.out.println("**************");
        return new RedirectView("login");}

    @PostMapping("/login")
    public RedirectView logInUser(String username, String password) {
        SiteUser loginUserDB = AuthenticationRepository.findByUsername(username);
        if((loginUserDB == null)
           || !(BCrypt.checkpw(password,loginUserDB.getPassword()))){
           return new RedirectView("/login");
        }


        return new RedirectView("/");
    }


}


