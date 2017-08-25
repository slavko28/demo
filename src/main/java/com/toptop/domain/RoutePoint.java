package com.toptop.domain;

import com.toptop.domain.enums.RouteActivityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class RoutePoint extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1961569891607287672L;

    @OneToOne(optional = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    private RouteActivityType type;

    private String additionalInformation;
}
