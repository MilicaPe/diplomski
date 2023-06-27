package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @Column
    private Integer yearOfBirth;

    @Column
    private Gender gender;
    @Column
    private String job;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmotionResult> emotionResults;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_psychologist",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "psychologist_id", referencedColumnName = "id"))
    private List<User> psychologists;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "psychologists")
    private List<User> clients;


    public boolean containsInNameOrEmail(String params) {
        if (name.toLowerCase().contains(params)) return true;
        if (surname.toLowerCase().contains(params)) return true;
        if (email.toLowerCase().contains(params)) return true;
        return false;
    }

    public void addPsychologist(User psychologist) {
        for (User p : psychologists){
            if (p.getId() == psychologist.getId()){
                return;
            }
        }
        this.psychologists.add(psychologist);
    }

    public void removePsychologist(User psychologist) {
        for (User p : psychologists){
            if (p.getId() == psychologist.getId()){
                this.psychologists.remove(p);
                return;
            }
        }
    }
}
