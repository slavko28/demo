package com.toptop.service.dto;

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
public class OrderDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private Double transportationCost;

    @NotNull
    private Double orderProfit; // TODO change to jodamoney

    private LocalDateTime completeDate;

    @NotNull
    private Long companyOrderId;

    @NotNull
    private Long carrierId;

    @NotNull
    private Long truckId;

    private String TruckLicensePlate;

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
