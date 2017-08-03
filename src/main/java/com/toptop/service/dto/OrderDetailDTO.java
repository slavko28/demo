package com.toptop.service.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OrderDetailDTO implements Serializable {

    private Long id;

    @NotNull
    private Double transportationCost;

    @NotNull
    private Double orderProfit; // TODO change to jodamoney

    private LocalDateTime completeDate;

    @NotNull
    private Long orderId;

    @NotNull
    private Long carrierId;

    @NotNull
    private Long truckId;

    private String truckLicensePlate;

    @NotNull
    private Long trailerId;

    private String trailerLicensePlate;

    @NotNull
    private Long driverId;

    private String driverFirstName;

    private String driverLastName;

    @NotNull
    private Long managerId;

    private String managerFirstName;

    private String managerLastName;

}
