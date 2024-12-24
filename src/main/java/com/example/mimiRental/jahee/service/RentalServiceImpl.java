package com.example.mimiRental.jahee.service;

import com.example.mimiRental.jahee.dao.RentalDAO;
import com.example.mimiRental.jahee.entity.RentalEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
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

    public RentalEntity findByRentalId(Long RentalId) {
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
        LocalDateTime currentTime = LocalDateTime.now();
        Date updatereturnDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());
        //RentalEntity rental = rentalDao.findByRentalId(rental.getRentalId());
        // 반환 날짜 설정
        rental.setReturnDate(updatereturnDate);
        rentalDAO.updateReturnDate(rental);
        // Date를 LocalDateTime으로 변환
        LocalDateTime rentalDateTime = rental.getRentalDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        // 대여기간 계산: returnDate와 rentalDate의 차이로 대여기간 계산
        long daysBetween = Duration.between(rentalDateTime, currentTime).toDays();
        rental.setRentalPeriod((int) daysBetween);
        rentalDAO.updateRentalPeriod(rental);
    }
}
