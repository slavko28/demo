package com.toptop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User implements Serializable{

    private static final long serialVersionUID = -2025326803520891508L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String login;

    @JsonIgnore
    private String password;

    @NotNull
    private String phoneNumber;

    @NotNull
    @OneToMany
    private Set<Authority> authorities = new HashSet<>();
}
