package com.toptop.service.dto;

import com.toptop.domain.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private Double transportationCost;

    @NotNull
    private Double orderProfit; // TODO change to jodamoney

    private LocalDateTime completeDate;

    @NotNull
    private CompanyOrder order;

    @NotNull
    private Company carrier;

    @NotNull
    private Truck truck;

    @NotNull
    private Trailer trailer;

    @NotNull
    private CompanyEmployee driver;

    @NotNull
    private CompanyEmployee manager;

}
