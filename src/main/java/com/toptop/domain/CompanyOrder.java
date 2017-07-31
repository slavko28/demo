package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
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
    private double budget; // TODO change to jodamoney

    @NotNull
    private String downloadingPlace;

    @NotNull
    private String downloadingType;

    @NotNull
    private String uploadingPlace;

    private int volume;

    @NotNull
    private double weight;

    @NotNull
    private String description;

    @ManyToOne
    private Company company;

    @ManyToOne
    private CompanyEmployee manager; // from

    @OneToOne
    private OrderDetails orderDetails;
}
