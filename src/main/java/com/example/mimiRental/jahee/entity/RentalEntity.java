package com.example.mimiRental.jahee.entity;

import com.example.mimiRental.publicEntity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rental")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalEntity extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private Long userId;
    private Long mgmNum;
    private Date rentalDate;
    private int rentalPeriod;
    private Date dueDate;
    private Date returnDate;
    private String item;//"노트북"

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

    public RentalEntity(Long userId, Date rentalDate, int rentalPeriod, Date dueDate, String item) {
        this.userId = userId;
        this.rentalDate = rentalDate;
        this.rentalPeriod = rentalPeriod;
        this.dueDate = dueDate;
        this.item = item;
    }

    public RentalEntity(Long userId, int rentalPeriod, Date dueDate) {
        this.dueDate = dueDate;
        this.userId = userId;
        this.rentalPeriod = rentalPeriod;
    }
}

