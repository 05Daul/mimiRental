package com.example.mimiRental.jahee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRentalDTO {
    private Long userId;
    private Long mgmNum;
    private Date rentalDate;
    private int rentalPeriod;
    private Date dueDate;
    private Date returnDate;
    private String item;//"노트북"

    public RequestRentalDTO(Long userId, Date rentalDate, int rentalPeriod, Date dueDate, String item) {
        this.userId = userId;
        this.rentalDate = rentalDate;
        this.rentalPeriod = rentalPeriod;
        this.dueDate = dueDate;
        this.item = item;
    }
}
