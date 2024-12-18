package com.example.mimiRental.jahee.service;

import com.example.mimiRental.jahee.dao.RentalDAO;
import com.example.mimiRental.jahee.entity.RentalEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalService {
    //    @NonNull
    private final RentalDAO rentalDAO;

    public void insert(RentalEntity rental) {
        rentalDAO.insert(rental);
    }
    /*
        public void insertrental(UsersEntity user, EquipmentEntity e,int rentalPeriod ){
            rentalDAO.insert(new RentalEntity(user.getUserId(),e.)getMgmNum(),rentalPeriod);
        }
    */
    public RentalEntity findByRentalId(String RentalId) {
        return rentalDAO.findByRentalId(RentalId);
    }
    public List<RentalEntity> findAll() {
        return rentalDAO.findAll();
    }
    public List<RentalEntity> findListByUserId(String UserId) {
        return rentalDAO.findListByUserId(UserId);
    }
    public void delete(RentalEntity rental) {
        rentalDAO.delete(rental);
    }
    public void updateRentalPeriod(RentalEntity rental) {
        rentalDAO.updateRentalPeriod(rental);
    }
    public void updateMgmNumUserId(RentalEntity rental) {
        rentalDAO.updateMgmNumUserId(rental);
    }
    public void updateReturnDate(RentalEntity rental) {
        rentalDAO.updateReturnDate(rental);
    }
}
