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

    private LinkedList<RoutePoint> routePoints;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoutePoint {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Address address;

        @Enumerated(EnumType.STRING)
        private RouteActivityType type;
    }
}
