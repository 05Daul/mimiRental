package com.example.mimiRental.jahee.Controller;

import com.example.mimiRental.jahee.RequestInsertDTO;
import com.example.mimiRental.jahee.entity.RentalEntity;
import com.example.mimiRental.jahee.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final RentalService service;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody RequestInsertDTO dto) {
        RentalEntity rentalEntity = new RentalEntity(dto.getUserId(), dto.getMgmNum(), dto.getRentalPeriod());
        service.insert(rentalEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public void updateRentalPeriod() {
        service.updateRentalPeriod(new RentalEntity(3L, 110));
    }

    @GetMapping("/delete")
    public void deleteRental() {
        RentalEntity deleterental = service.findByRentalId("3");
        service.delete(deleterental);
    }

    @GetMapping("/find")
    public RentalEntity findByRentalId() {
        String RentalId = "3";
        return service.findByRentalId(RentalId);
    }


}
