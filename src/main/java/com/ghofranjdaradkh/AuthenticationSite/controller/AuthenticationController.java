package com.ghofranjdaradkh.AuthenticationSite.controller;

import com.ghofranjdaradkh.AuthenticationSite.Repository.AuthenticationRepository;
import com.ghofranjdaradkh.AuthenticationSite.models.SiteUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


    @PostMapping("/loginWithSecret")
    public RedirectView logInUserWithSecret(HttpServletRequest request, String username, String password) {
        SiteUser loginUserDB = AuthenticationRepository.findByUsername(username);

        if (loginUserDB == null) {
            // user does not exist
            return new RedirectView("/login");
            // password is incorrect
        } else if (!BCrypt.checkpw(password, loginUserDB.getPassword())) {

            return new RedirectView("/login");
        } else {
                //correct
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return new RedirectView("/");
        }
    }


    @GetMapping ("/logout")
    public RedirectView logout (){
    return new RedirectView("/signup");
    }
}


