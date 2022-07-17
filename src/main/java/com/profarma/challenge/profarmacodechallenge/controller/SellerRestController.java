package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.common.ApiResponse;
import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.dto.SellerProductDto;
import com.profarma.challenge.profarmacodechallenge.service.ISellerProductService;
import com.profarma.challenge.profarmacodechallenge.service.ISellerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promofarma/seller")
public class SellerRestController {

    @Autowired
    @Qualifier("sellerService")
    private ISellerService sellerService;

    @Autowired
    @Qualifier("sellerProductService")
    private ISellerProductService sellerProductService;

    @Operation(summary = "Creates new seller in DB")
    @PostMapping(path = "/add/{sellerName}")
    public ResponseEntity<ApiResponse> createSeller(@PathVariable(value = "sellerName") String sellerName) {
        SellerDto sellerDto = new SellerDto();
        sellerDto.setSellerName(sellerName);
        if (sellerService.findSellerByName(sellerDto) == null) {
            sellerService.save(sellerDto);
            return new ResponseEntity<>(new ApiResponse("Seller has been created."), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponse("Seller already exists."), HttpStatus.CONFLICT);
    }

    @Operation(summary = "Return the list of all sellers in DB")
    @GetMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SellerDto>> getSellers() {
        List<SellerDto> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @Operation(summary = "Unlink a product from a seller")
    @DeleteMapping(path = "/{sellerId}/{productId}")
    public ResponseEntity<ApiResponse> removeProductToSeller(@PathVariable(value = "sellerId") Long sellerId, @PathVariable(value = "productId") Long productId) {
        sellerProductService.removeProductToSeller(sellerId, productId);
        return new ResponseEntity<>(new ApiResponse("Product unlinked from seller"), HttpStatus.OK);
    }

    @Operation(summary = "Link one or more products to a seller")
    @PostMapping(path = "/{sellerId}/product")
    public ResponseEntity<ApiResponse> addProductToSeller(@PathVariable(value = "sellerId") Long sellerId, @RequestBody List<SellerProductDto> sellerProductDto) {
        sellerProductService.addProductsToSeller(sellerId, sellerProductDto);
        return new ResponseEntity<>(new ApiResponse("New products linked to seller"), HttpStatus.OK);
    }

    @Operation(summary = "Deletes a seller by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteSeller(@PathVariable(value = "id") Long id) {
        if (sellerService.findById(id) != null) {
            sellerService.deleteSeller(id);
            return new ResponseEntity<>(new ApiResponse("Seller has been deleted."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("The Seller does not exists in the DB"), HttpStatus.CONFLICT);
    }

}
