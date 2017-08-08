package com.toptop.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Order detail.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;

    @Id
    @GeneratedValue
    private Long id;
    private Double transportationCost;
    private Double orderProfit; // TODO change to jodamoney
    private LocalDateTime completeDate;
    @OneToOne(optional = false)
    private CompanyOrder companyOrder;
    @ManyToOne(optional = false)
    private Company carrier;
    @ManyToOne(optional = false)
    private Truck truck;
    @ManyToOne(optional = false)
    private Trailer trailer;
    @ManyToOne(optional = false)
    private CompanyEmployee driver;
    @ManyToOne(optional = false)
    private User manager;
}
