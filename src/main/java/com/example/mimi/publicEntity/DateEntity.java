package com.example.mimi.publicEntity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public class DateEntity {
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;}
