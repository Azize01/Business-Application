package com.example.demo.model;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", nullable = false, length = 40)
    private String fullName;
    private String username;
    private String password;
    private String salesRepresentativeUsername;
    private String role;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection <Role> roles;

    public User() {

    }

    public User(String fullName, String username, String password, Collection<Role> roles, String role) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.role=role;
    }

   /*public User(String fullName, String username, String password, String role) {
       super();
       this.fullName = fullName;
       this.username = username;
       this.password = password;
       this.role=role;}*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalesRepresentativeUsername() {
        return salesRepresentativeUsername;
    }

    public void setSalesRepresentativeUsername(String salesRepresentativeUsername) {
        this.salesRepresentativeUsername = salesRepresentativeUsername;
    }
}
