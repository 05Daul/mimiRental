package com.example.mimiRental.jahee.repository;

import com.example.mimiRental.jahee.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalEntity,Long> {
    List<RentalEntity> findByUserId(Long userId);  // userId로 여러 개의 RentalEntity 반환

}
