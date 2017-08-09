package com.toptop.domain;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.LinkedList;

/**
 * Route.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "route_points", nullable = false)
    @NotEmpty
    private LinkedList<RoutePoint> routePoints;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutePoint {

        private Address address;

        @Enumerated(EnumType.STRING)
        private RouteActivityType type;
    }
}
