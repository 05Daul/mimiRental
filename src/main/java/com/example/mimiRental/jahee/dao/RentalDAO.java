package com.example.mimiRental.jahee.dao;

import com.example.mimiRental.jahee.entity.RentalEntity;

import java.util.List;

public interface RentalDAO {
    void insert(RentalEntity rental);
    RentalEntity findByRentalId(String rentalId);
    RentalEntity findByRentalId(Long rentalId);
    List<RentalEntity> findListByUserId(String userid);
    void updateRentalPeriod(RentalEntity rental);
    void updateMgmNumUserId(RentalEntity rental);
    void updateReturnDate(RentalEntity rental);
    List<RentalEntity> findAll();
    void delete(RentalEntity rental);
}
