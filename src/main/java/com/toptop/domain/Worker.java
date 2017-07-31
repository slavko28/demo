package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Worker implements Serializable{

    private static final long serialVersionUID = -8656867795070348248L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String midName;

    @NotNull
    private String phoneNumber;

}
