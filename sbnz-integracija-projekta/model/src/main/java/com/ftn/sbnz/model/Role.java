package com.ftn.sbnz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="role")
@Getter
@Setter
public class Role  implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "roles",  fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Set<Privileges> privileges;


    public String getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public Role(String name) {
        this.name = name;
    }
    public Role(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }




}
