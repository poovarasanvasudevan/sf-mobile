package com.caretech.servicefocus.mobile.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "SYS_ROLE")
public class Role extends Base implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
