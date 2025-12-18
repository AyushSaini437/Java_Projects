package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    /*
    * @ID used to define the primary key
    * @GenerateValue used to put ID automatically
    *
    * NOTE!!!
    * If there is any duplicate data with different ID and you delete one of them, it won't correct the ID order
    * eg:- ID 2 and 3 has same data, and you delete ID 2 and then if you fetch data from the database it will show you
    * IDs like 1, 3, 4.....

    * TO fix this we will need our own logic
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * Username must be unique and can't be nullable
    */
    @Column(unique = true, nullable = false)
    private String username;

    /*
    * Password can't be nullable
    */
    @Column(nullable = false)
    private String password;

    /*
    * @ManyToMany is the mapping, and in this scenario it means many users can have same role and same role is given to
    * many user

    * fetch means to fetch data from the database and EAGER type tells to load the associated data or entities
    * immediately along with parent class

    * cascade used in association in between entities and tell which operation to be performed on the associated entities
    * CascadeType is used to tell that operation
    * MERGE:- To update the associated entities
    * PERSIST:- To save all the associated entities
    * REMOVE:- To delete an entity and all the associated entities
    * REFRESH:- To refresh the entities
    * DETACH:- To detach the entities
    * ALL:- To perform all these operations at once
    */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Constructors
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}