package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;
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

    private BigDecimal transportationCost;
    private BigDecimal orderProfit;
    private LocalDateTime completeDate;

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
