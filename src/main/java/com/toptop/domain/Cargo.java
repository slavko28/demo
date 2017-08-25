package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *  Cargo.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class Cargo extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1279832782032842890L;

    private double volume;
    private double weight;
    private String description;
}
