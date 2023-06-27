package com.ftn.sbnz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Privileges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role_privilege",
            joinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
