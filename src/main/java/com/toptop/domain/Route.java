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
public class Route extends BaseObject implements Serializable {

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoutePoint> routePoints;

    private String additionalInformation;
}
