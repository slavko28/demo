package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Carrier implements Serializable{

    private static final long serialVersionUID = -999643553048001899L;

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)
    private Company company;

    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY)
    private Set<Truck> trucks;

    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY)
    private Set<Trailer> trailers;

    @OneToMany(mappedBy = "carrier", fetch = FetchType.LAZY)
    private Set<Driver> drivers;

}
