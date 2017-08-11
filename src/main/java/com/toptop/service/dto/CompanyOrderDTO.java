package com.toptop.service.dto;

import com.toptop.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyOrderDTO implements Serializable {

    private Long id;

    @NotNull
    private OrderStatus orderStatus;

    @NotNull
    private LocalDateTime orderDate;

    private Money budget;

    @NotNull
    private RouteDTO route;

    @NotNull
    private String downloadingType;

    @NotNull
    private CargoDTO cargo;

    @NotNull
    private CompanyDTO company;

    @NotNull
    private CompanyEmployeeDTO manager;

    private OrderDetailDTO orderDetails;
}