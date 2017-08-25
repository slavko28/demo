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
public class OrderDetail extends BaseObject implements Serializable {

    private static final long serialVersionUID = -6693482470482522203L;

    private Money transportationCost;
    private Money orderProfit;
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
