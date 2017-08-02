package com.toptop.service.dto;

import com.toptop.domain.Authority;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String login;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Set<Authority> authorities;
}
