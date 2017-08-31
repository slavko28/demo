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

    private static final long serialVersionUID = -4162256215462372752L;

    @OneToMany
    private List<RoutePoint> routePoint;

    private String additionalInformation;
}
