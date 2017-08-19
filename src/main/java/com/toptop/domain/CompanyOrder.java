package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

/**
 * Company order.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "company_order")
public class CompanyOrder extends BaseObject implements Serializable {

    private static final long serialVersionUID = 3610318214071648278L;

    @Enumerated(STRING)
    @Column(name = "order_status")
    private OrderStatus status;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "budget")
    private Money budget;

    @OneToOne(optional = false)
    private Route route;

    @Column(name = "downloading_type")
    private String downloadingType;

    @OneToOne(optional = false)
    private Cargo cargo;

    @ManyToOne(optional = false)
    private Company company;

    @ManyToOne(optional = false)
    private CompanyEmployee manager;

}
