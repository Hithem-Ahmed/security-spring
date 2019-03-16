package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserDO {
    @Id
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "username")
    private Set<RoleDO> roles = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public UserDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<RoleDO> getRoles() {
        return new HashSet<>(roles);
    }

    public UserDO setRoles(Set<RoleDO> roles) {
        this.roles = new HashSet<>(roles);
        return this;
    }
}
