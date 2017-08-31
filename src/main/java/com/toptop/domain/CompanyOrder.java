package com.toptop.domain;

import com.toptop.domain.enums.LoadingType;
import com.toptop.domain.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Company order.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class CompanyOrder extends BaseObject implements Serializable {

    private static final long serialVersionUID = -5439458620107939326L;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime orderDate;
    private BigDecimal budget;

    @OneToOne(optional = false)
    private Route route;

    @Enumerated(EnumType.STRING)
    private LoadingType loadingType;

    @OneToOne(optional = false)
    private Cargo cargo;

    @ManyToOne(optional = false)
    private Company company;

    @ManyToOne(optional = false)
    private CompanyEmployee manager;

}
