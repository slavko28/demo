package com.toptop.service.dto;

import com.toptop.domain.Company;
import com.toptop.domain.enums.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
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
    private Set<String> downloadingPlace;

    @NotNull
    private String downloadingType;

    @NotNull
    private Set<String> uploadingPlace;

    private int volume;

    @NotNull
    private double weight;

    @NotNull
    private String description;

    private Company company;

    @NotNull
    private Long managerId;

    private String managerFirstName;

    private String managerLastName;

    private Long orderDetailsId;

}
