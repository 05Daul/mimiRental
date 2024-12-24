package com.example.mimiRental.jahee.service;

import com.example.mimiRental.jahee.RequestRentalDTO;
import com.example.mimiRental.jahee.RequestUpdateRentalDTO;
import com.example.mimiRental.jahee.entity.RentalEntity;

import java.util.List;

public interface RentalService {
    void insert(RentalEntity rental);
    RentalEntity findByRentalId(String RentalId);
    RentalEntity findByRentalId(Long RentalId);
    List<RentalEntity> findAll();
    List<RentalEntity> findListByUserId(String UserId);
    void delete(RentalEntity rental);
    void updateRentalPeriod(RentalEntity rental);
    void updateMgmNumUserId(RequestUpdateRentalDTO dto);
    void updateReturnDate(RentalEntity rental);
}
