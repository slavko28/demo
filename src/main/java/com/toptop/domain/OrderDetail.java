package com.toptop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private Double transportationCost;

    @NonNull
    private Double orderProfit; // TODO change to jodamoney

    private LocalDateTime completeDate;

    @NonNull
    @OneToOne(optional = false)
    private CompanyOrder companyOrder;

    @NonNull
    @ManyToOne(optional = false)
    private Company carrier;

    @NonNull
    @ManyToOne(optional = false)
    private Truck truck;

    @NonNull
    @ManyToOne(optional = false)
    private Trailer trailer;

    @NonNull
    @ManyToOne(optional = false)
    private CompanyEmployee driver;

    @NonNull
    @ManyToOne(optional = false)
    private User manager;
}
