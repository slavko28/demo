package com.toptop.service.dto;

import com.toptop.domain.enums.LoadingType;
import com.toptop.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyOrderDTO implements Serializable {

    private Long id;

    private OrderStatus status;

    @NotNull
    private LocalDateTime orderDate;

    private BigDecimal budget;

    @NotNull
    private RouteDTO route;

    @NotNull
    private LoadingType loadingType;

    @NotNull
    private CargoDTO cargo;

    @NotNull
    private CompanyDTO company;

    @NotNull
    private CompanyEmployeeDTO manager;

    private OrderDetailDTO orderDetail;


}