package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompanyOrder implements Serializable {

    private static final long serialVersionUID = 3610318214071648278L;

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Enumerated(STRING)
    private OrderStatus orderStatus;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    private Double budget; // TODO change to jodamoney

    @NotNull
    @OneToMany
    private Set<Address> downloadingPlace = new HashSet<>();

    @NotNull
    private String downloadingType;

    @NotNull
    @OneToMany
    private Set<Address> uploadingPlace = new HashSet<>();

    private int volume;

    @NotNull
    private double weight;

    @NotNull
    private String description;

    @ManyToOne(optional = false)
    private Company company;

    @ManyToOne(optional = false)
    private CompanyEmployee manager;

    @OneToOne
    private OrderDetail orderDetail;
}
