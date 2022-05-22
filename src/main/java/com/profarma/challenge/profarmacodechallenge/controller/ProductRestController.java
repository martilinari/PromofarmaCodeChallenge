package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import com.profarma.challenge.profarmacodechallenge.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    @Qualifier("productService")
    private IProductService productService;


    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getProducts() {
        List<ProductDto> productList = productService.findAll();
        if (null != productList && productList.size() != 0) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/add_product")
//    public ResponseEntity<Void> addProduct(@RequestBody ProductEntity product) {
//        if (sellerService.findSeller(seller) == null) {
//            sellerService.save(seller);
//            return new ResponseEntity<Void>(HttpStatus.CREATED);
//        }
//        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteSeller(@PathVariable(value = "id") Long id) {
//        SellerEntity sellerDB = null;
//        sellerDB = sellerService.findById(id);
//        if (sellerDB != null) {
//            sellerService.deleteSeller(id);
//            return new ResponseEntity<Void>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//        }
//    }

}
