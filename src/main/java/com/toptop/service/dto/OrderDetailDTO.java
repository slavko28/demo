package com.toptop.service.dto;

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
public class OrderDetailDTO implements Serializable {

    private Long id;

    @NotNull
    private BigDecimal transportationCost;

    @NotNull
    private BigDecimal orderProfit;

    private LocalDateTime completeDate;

//    @NotNull
//    private CompanyOrderDTO companyOrder;

    @NotNull
    private CompanyDTO carrier;

    @NotNull
    private TruckDTO truck;

    @NotNull
    private TrailerDTO trailer;

    @NotNull
    private CompanyEmployeeDTO driver;

    @NotNull
    private UserDTO manager;
}
