package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.common.ApiResponse;
import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.service.IProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @ApiOperation(value = "Creates new product in DB")
    @PostMapping(path = "/create_product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        if (productService.findProductByName(productDto) == null) {
            productService.save(productDto);
            return new ResponseEntity<>(new ApiResponse("Product has been created."), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponse("Product already exists."), HttpStatus.CONFLICT);
    }

    @ApiOperation(value = "Return the list of all products in DB")
    @GetMapping(path = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long id) {
        ProductEntity product = null;
        product = productService.findById(id);
        if (product != null) {
            productService.deleteProduct(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
