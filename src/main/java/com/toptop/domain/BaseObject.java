package com.toptop.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "enabled")
    private Boolean enabled = true;
}
