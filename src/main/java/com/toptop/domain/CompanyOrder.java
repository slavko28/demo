package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Company order.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class CompanyOrder extends BaseObject implements Serializable {

    private static final long serialVersionUID = 3610318214071648278L;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime orderDate;
    private Money budget;

    @OneToOne(optional = false)
    private Route route;

    private String downloadingType;

    @OneToOne(optional = false)
    private Cargo cargo;

    @ManyToOne(optional = false)
    private Company company;

    @ManyToOne(optional = false)
    private CompanyEmployee manager;

}
