package com.toptop.service.dto;

import com.toptop.domain.RoutePoint;
import com.toptop.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    private Double budget; // TODO change to jodamoney

    @NotNull
    private List<RoutePoint> route;

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