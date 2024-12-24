package com.example.mimiRental.jahee.Controller;

import com.example.mimiRental.jahee.RequestRentalDTO;
import com.example.mimiRental.jahee.entity.RentalEntity;
import com.example.mimiRental.jahee.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {
    private final RentalService service;

    @PostMapping("/apply")
    public ResponseEntity<?> insert(@RequestBody RequestRentalDTO dto) {
        System.out.println("ggg");
        RentalEntity rentalEntity = new RentalEntity(dto.getUserId(), dto.getRentalDate(),dto.getRentalPeriod(), dto.getDueDate(),dto.getItem());
        service.insert(rentalEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/insert")
//    public ResponseEntity<?> insert(@RequestBody RentalEntity insertrental) {
//        service.insert(insertrental);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping("/updatemgmnum")
    public ResponseEntity<?> updatemgmnum(@RequestBody RequestRentalDTO dto) {
        RentalEntity rentalEntity = new RentalEntity(dto.getUserId(), dto.getRentalPeriod(), dto.getDueDate());
        service.updateMgmNumUserId(rentalEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update")
    public void updateRentalPeriod(@RequestParam Long rentalId, @RequestParam int rentalPeriod) {
        service.updateRentalPeriod(new RentalEntity(rentalId, rentalPeriod));
    }

    @GetMapping("/delete")
    public void deleteRental(@RequestParam Long rentalId) {
        RentalEntity deleterental = service.findByRentalId(rentalId);
        service.delete(deleterental);
    }

    @GetMapping("/find")
    public RentalEntity findByRentalId(@RequestParam String rentalId) {
        return service.findByRentalId(rentalId);
    }

    @GetMapping("/findall")
    public List<RentalEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/return")
    public ResponseEntity<?> returnRental(@RequestParam Long rentalId) {
        RentalEntity rental = service.findByRentalId(rentalId);
        service.updateReturnDate(rental);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @GetMapping("/findrental/{userId}")
    public List<RentalEntity> findRentalByUserId(@PathVariable String userId) {
        return service.findListByUserId(userId);
    }


}
