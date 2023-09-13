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
    public RedirectView addNewPost(String text,SiteUser siteUser , Model model) {
//        if (userId == null) {
//            return new RedirectView("/");
//        }
         long userId= siteUser.getId();

        SiteUser siteUser1  = authenticationRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Posts newPost = new Posts(text, siteUser1);
        postRepository.save(newPost);


        return new RedirectView("/allPosts");
    }
}
