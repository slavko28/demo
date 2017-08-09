package com.toptop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  Cargo.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "volume")
    private int volume;

    @Column(name = "weight")
    private double weight;

    @Column(name = "description")
    private String description;
}
