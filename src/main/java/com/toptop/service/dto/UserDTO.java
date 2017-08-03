package com.toptop.service.dto;

import com.toptop.domain.Authority;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String email; // TODO: add Constants MAIL_REGEX

    @NotNull
    private String login; // TODO: add Constants LOGIN_REGEX

    @NotNull
    private String phoneNumber; // TODO: add Constants PHONE_REGEX

    @NotNull
    private Set<Authority> authorities;
}
