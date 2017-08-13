package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Route.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "route")
public class Route extends BaseObject<Route> implements Serializable {

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoutePoint> routePoints;

    @Column(name = "additional_information")
    private String additionalInformation;
}
