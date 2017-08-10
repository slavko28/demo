package com.toptop.service.dto;

import com.toptop.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    private String email; // TODO: add Constants MAIL_REGEX

    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber; // TODO: add Constants PHONE_REGEX

    private Boolean active;

    private UserRole role;
}
