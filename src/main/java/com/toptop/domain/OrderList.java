package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderList implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Enumerated(STRING)
    private OrderStatus orderStatus;

    @NonNull
    private Double transportationCost;

    @NonNull
    private Double orderProfit;

    private LocalDateTime completeDate;

    @NonNull
    @ManyToOne(optional = false)
    private CustomerOrder order;

    @NonNull
    @ManyToOne(optional = false)
    private Carrier carrier;

    @NonNull
    @ManyToOne(optional = false)
    private Truck truck;

    @NonNull
    @ManyToOne(optional = false)
    private Trailer trailer;

    @NonNull
    @ManyToOne(optional = false)
    private Worker driver;

    @NonNull
    @ManyToOne(optional = false)
    private User user;
}
