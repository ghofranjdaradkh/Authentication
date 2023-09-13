package com.ghofranjdaradkh.AuthenticationSite.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    String username;
    String password;

    @OneToMany(mappedBy = "siteUser", cascade = CascadeType.ALL)
    private List<Posts> posts;

    public SiteUser(Long id, String username, String password, List<Posts> posts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public SiteUser() {

    }

    public SiteUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
