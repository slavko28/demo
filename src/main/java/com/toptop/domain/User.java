package com.toptop.domain;

import com.toptop.domain.enums.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "tt-user")
public class User extends BaseObject implements Serializable {

    private static final long serialVersionUID = -2025326803520891508L;

    private String email;
    private String password;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
