package com.toptop.domain;

import lombok.*;
import org.joda.money.Money;

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
@Data
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "transportation_cost")
    private Double transportationCost;

    @Column(name = "order_profit")
    private Money orderProfit;

    @Column(name = "complete_date")
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
