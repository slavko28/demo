package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Order detail.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "order_detail")
public class OrderDetail extends BaseObject<OrderDetail> implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;

    @Column(name = "transportation_cost")
    private Money transportationCost;

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
