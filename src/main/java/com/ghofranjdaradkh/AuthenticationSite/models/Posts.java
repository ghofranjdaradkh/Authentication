package com.ghofranjdaradkh.AuthenticationSite.models;

import javax.persistence.*;

@Entity
public class Posts {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    String text;


    @ManyToOne
    SiteUser siteUser;


    public Posts() {
    }

    public Posts( String text, SiteUser siteUser) {
        this.text = text;
        this.siteUser = siteUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }
}










