package com.example.mimiRental.jahee.dao;


import com.example.mimiRental.jahee.entity.RentalEntity;
import com.example.mimiRental.jahee.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalDAOImpl implements RentalDAO {
    private final RentalRepository repository;

    public void insert(RentalEntity rental) {
        repository.save(rental);
    }

    public RentalEntity findByRentalId(String rentalId) {
        return repository.findById(Long.parseLong(rentalId)).orElse(null);
    }

    public RentalEntity findByRentalId(Long rentalId) {
        return repository.findById(rentalId).orElse(null);
    }

    public List<RentalEntity> findListByUserId(String userid) {
        Long lkey = Long.parseLong(userid);
        return repository.findByUserId(lkey);  // JpaRepository의 자동 생성된 메서드 사용
////        return     repository.createQuery("select r from RentalEntity r where userId = ").getResultList()
//        Long lkey = Long.parseLong(userid);
//        Query query = repository.createQuery("select r from RentalEntity r where r.userId =:key");
//        query.setParameter("key", lkey);
//        return query.getResultList();
    }

    public void updateRentalPeriod(RentalEntity rental) {
        RentalEntity updaterental = repository.findById(rental.getRentalId()).orElse(null);
        if (updaterental != null) {
            updaterental.setRentalPeriod(rental.getRentalPeriod());
            repository.save(updaterental);  // 변경사항 저장
        }
    }

    public void updateMgmNumUserId(RentalEntity rental) {
        RentalEntity updaterental = repository.findById(rental.getRentalId()).orElse(null);
        if (updaterental != null) {
            updaterental.setMgmNum(rental.getMgmNum());
            updaterental.setUserId(rental.getUserId());
            repository.save(updaterental);
        }
    }

    public void updateReturnDate(RentalEntity rental) {
        RentalEntity updaterental = repository.findById(rental.getRentalId()).orElse(null);
        if (updaterental != null) {
            updaterental.setReturnDate(rental.getReturnDate());
            repository.save(updaterental);
        }
    }

    public List<RentalEntity> findAll() {
        return repository.findAll();
    }

    public void delete(RentalEntity rental) {
        RentalEntity deleterental = repository.findById(rental.getRentalId()).orElse(null);
        if (deleterental != null) {
            repository.delete(deleterental);
        }
    }
}
