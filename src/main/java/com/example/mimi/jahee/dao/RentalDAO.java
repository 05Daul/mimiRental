package com.example.mimi.jahee.dao;


import com.example.mimi.jahee.entity.RentalEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalDAO {
    private final EntityManager entityManager;
    public void insert(RentalEntity rental) {
        entityManager.persist(rental);
    }
    public RentalEntity findByRentalId(String rentalId) {
        return entityManager.find(RentalEntity.class, Long.parseLong(rentalId));
    }
    public List<RentalEntity> findListByUserId(String userid) {
//        return entityManager.createQuery("select r from RentalEntity r where userId = ").getResultList()
        Long lkey = Long.parseLong(userid);
        Query query = entityManager.createQuery("select r from RentalEntity r where r.userId =:key");
        query.setParameter("key", lkey);
        return  query.getResultList();
    }

    public void updateRentalPeriod(RentalEntity rental) {
        RentalEntity updaterental = entityManager.find(RentalEntity.class,rental.getRentalId());
        updaterental.setRentalPeriod(rental.getRentalPeriod());
    }
    public void updateMgmNumUserId(RentalEntity rental) {
        RentalEntity updaterental = entityManager.find(RentalEntity.class,rental.getRentalId());
        updaterental.setMgmNum(rental.getMgmNum());
        updaterental.setUserId(rental.getUserId());
    }

    public void updateReturnDate(RentalEntity rental) {
        RentalEntity updaterental = entityManager.find(RentalEntity.class,rental.getRentalId());
        updaterental.setReturnDate(rental.getReturnDate());
    }
    public List<RentalEntity> findAll() {
        return entityManager.createQuery("select r from RentalEntity r").getResultList();
    }
    public void delete(RentalEntity rental) {
        RentalEntity deleterental = entityManager.find(RentalEntity.class, rental.getRentalId());
        entityManager.remove(deleterental);
    }
}
