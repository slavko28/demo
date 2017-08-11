package com.toptop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Route.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoutePoint> routePoints;

    @Column(name = "additional_information")
    private String additionalInformation;
}
