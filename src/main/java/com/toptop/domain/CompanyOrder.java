package com.toptop.domain;

import com.toptop.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

/**
 * Company order.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompanyOrder implements Serializable {

    private static final long serialVersionUID = 3610318214071648278L;

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(STRING)
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private Double budget; // TODO change to jodamoney

    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> downloadingPlace;
    private String downloadingType;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> uploadingPlace;
    private int volume;
    private double weight;
    private String description;
    @ManyToOne(optional = false)
    private Company company;
    @ManyToOne(optional = false)
    private CompanyEmployee manager;
    @OneToOne
    private OrderDetail orderDetail;
}
