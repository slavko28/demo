package com.toptop.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseObject<T extends BaseObject> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
}
