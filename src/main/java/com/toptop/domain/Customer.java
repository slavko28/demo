package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer implements Serializable {

    private static final long serialVersionUID = 8348602723628231709L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne(optional = false)
    private Company company;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<CustomerOrder> orders;

}
