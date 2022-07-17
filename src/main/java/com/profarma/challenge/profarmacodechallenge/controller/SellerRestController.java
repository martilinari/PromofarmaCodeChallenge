package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.common.ApiResponse;
import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.service.ISellerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerRestController {

    @Autowired
    @Qualifier("sellerService")
    private ISellerService sellerService;

    @ApiOperation(value = "Creates new seller in DB")
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

    @ApiOperation(value = "Return the list of all sellers in DB")
    @GetMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SellerDto>> getSellers() {
        List<SellerDto> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a seller by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteSeller(@PathVariable(value = "id") Long id) {
        if (sellerService.findById(id) != null) {
            sellerService.deleteSeller(id);
            return new ResponseEntity<>(new ApiResponse("Seller has been deleted."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("The Seller does not exists in the DB"), HttpStatus.CONFLICT);
    }

    //    @PostMapping("/sellers/{id}/product")
    /**
     * {
     *   productId:2,
     *   price:20,
     *   ;
     *   productId:2,
     *   price:20,
     *
     * }
     *
     */
//    @GetMapping("/sellers")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<?> getSellers() {
//        List<SellerDto> sellerList = sellerService.findAll();
//        if (null != sellerList && sellerList.size() != 0) {
//            return new ResponseEntity<>(sellerList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//        }
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
