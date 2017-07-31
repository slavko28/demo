package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Company implements Serializable {

    private static final long serialVersionUID = 8399254940472545214L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String shortName;

    @NotNull
    private String fullName;

    @NotNull
    private int companyCod;

    @NotNull
    private String address;

    @NotNull
    private String phone;
}
