package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Manager implements Serializable {

    private static final long serialVersionUID = 1208265741954907625L;

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)
    private Worker worker;

    @ManyToOne(optional = false)
    private Customer customer;

    private String email;

    private String descriptionDetails;

}
