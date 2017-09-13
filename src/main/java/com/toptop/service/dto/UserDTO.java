package com.toptop.service.dto;

import com.toptop.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    private Boolean active;

    @NotNull
    private UserRole role;
}
