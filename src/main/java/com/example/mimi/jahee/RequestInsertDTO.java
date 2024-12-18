package com.example.mimi.jahee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInsertDTO {
    private Long userId;
    private Long mgmNum;
    private int rentalPeriod;

}
