package com.example.mimiRental.jahee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateRentalDTO {
    private Long rentalId;
    private Long userId;
    private Long mgmNum;
}
