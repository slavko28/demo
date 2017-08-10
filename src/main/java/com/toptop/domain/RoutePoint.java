package com.toptop.domain;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route_point")
public class RoutePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    private RouteActivityType type;

    @Column(name = "additional_information")
    private String additionalInformation;
}