package com.example.mimi.jahee.entity;

import com.example.mimi.publicEntity.DateEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "rental")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalEntity extends DateEntity {
    @Id
    @GeneratedValue
    private Long rentalId;
    private Long userId;
    private Long mgmNum;
    @CreationTimestamp
    private Date RentalDate;
    private int rentalPeriod;
    private Date DueDate;
    private Date ReturnDate;

    public RentalEntity(Long userId, Long mgmNum, int rentalPeriod) {
        this.userId = userId;
        this.mgmNum = mgmNum;
        this.rentalPeriod = rentalPeriod;
    }
    public RentalEntity(Long rentalId, int rentalPeriod) {
        this.rentalId = rentalId;
        this.rentalPeriod = rentalPeriod;
    }
    public RentalEntity(Long rentalId, Long userId, Long mgmNum) {
        this.rentalId = rentalId;
        this.userId = userId;
        this.mgmNum = mgmNum;
    }
}

