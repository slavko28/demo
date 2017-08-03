package com.toptop.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Authority.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Authority implements Serializable{

    private static final long serialVersionUID = 3468070781046341877L;

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

}
