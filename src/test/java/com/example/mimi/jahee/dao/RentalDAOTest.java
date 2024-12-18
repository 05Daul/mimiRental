package com.example.mimi.jahee.dao;

import com.example.mimi.jahee.entity.RentalEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(false)
class RentalDAOTest {
    @Autowired
    RentalDAO dao;

    @Test
    void insert() {
        dao.insert(new RentalEntity(1L,1L,120));
        dao.insert(new RentalEntity(2L,2L,120));
        dao.insert(new RentalEntity(4L,3L,120));
        dao.insert(new RentalEntity(3L,4L,120));
        dao.insert(new RentalEntity(5L,5L,120));
        dao.insert(new RentalEntity(6L,6L,120));
        dao.insert(new RentalEntity(7L,7L,120));
        dao.insert(new RentalEntity(8L,8L,120));
    }

    @Test
    void findById() {
        System.out.println(dao.findByRentalId("1"));
    }

    @Test
    void updateRentalPeriod() {
        dao.updateRentalPeriod(new RentalEntity(2L,23));
    }

    @Test
    void updateMgmNumUserId() {
        dao.updateMgmNumUserId(new RentalEntity(2L,10L,2L));

    }

    @Test
    void updateReturnDate() {
    }

    @Test
    void updateUserId() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}