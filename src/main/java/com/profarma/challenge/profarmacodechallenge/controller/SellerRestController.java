package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import com.profarma.challenge.profarmacodechallenge.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerRestController {

    @Autowired
    @Qualifier("sellerService")
    private ISellerService sellerService;

    @GetMapping("/sellers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getSellers() {
        List<SellerDto> sellerList = sellerService.findAll();
        if (null != sellerList && sellerList.size() != 0) {
            return new ResponseEntity<>(sellerList, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add_seller")
    public ResponseEntity<Void> addSeller(@RequestBody SellerEntity seller) {
        if (sellerService.findSeller(seller) == null) {
            sellerService.save(seller);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable(value = "id") Long id) {
        SellerEntity sellerDB = null;
        sellerDB = sellerService.findById(id);
        if (sellerDB != null) {
            sellerService.deleteSeller(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
