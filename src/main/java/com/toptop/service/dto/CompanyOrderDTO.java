package com.toptop.service.dto;

import com.toptop.domain.Company;
import com.toptop.domain.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompanyOrderDTO implements Serializable {

    private Long id;

    @NotNull
    private OrderStatus orderStatus;

    @NotNull
    private LocalDateTime orderDate;

    private Double budget; // TODO change to jodamoney

    @NotNull
    private String downloadingPlace;

    @NotNull
    private String downloadingType;

    @NotNull
    private String uploadingPlace;

    private int volume;

    @NotNull
    private double weight;

    @NotNull
    private String description;

    private Company company;

    private Long managerId;

    private Long orderDetailsId;

}
