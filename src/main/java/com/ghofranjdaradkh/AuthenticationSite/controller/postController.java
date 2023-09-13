package com.ghofranjdaradkh.AuthenticationSite.controller;

import com.ghofranjdaradkh.AuthenticationSite.Repository.AuthenticationRepository;
import com.ghofranjdaradkh.AuthenticationSite.Repository.PostRepository;
import com.ghofranjdaradkh.AuthenticationSite.models.Posts;
import com.ghofranjdaradkh.AuthenticationSite.models.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class postController {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/allPosts")
    public String getAllPosts(Model model) {
        List<Posts> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }



    @PostMapping("/addNewPost")
    public RedirectView addNewPost(HttpServletRequest request, String text) {
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        session.setAttribute("username", username);

        SiteUser siteUser = authenticationRepository.findByUsername(username);

        Posts newPost = new Posts(text, siteUser);
        postRepository.save(newPost);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++"+newPost.getText());
        return new RedirectView("/allPosts");
    }}

