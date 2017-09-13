package com.toptop.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseObject {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean enabled = true;
}
