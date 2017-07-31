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
public class Driver implements Serializable{

    private static final long serialVersionUID = -9093507966211622348L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Carrier carrier;

    @OneToOne(optional = false)
    private Worker worker;

    private String license;

    private String passport;

}
