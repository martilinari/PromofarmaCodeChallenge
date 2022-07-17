package com.profarma.challenge.profarmacodechallenge.controller;

import com.profarma.challenge.profarmacodechallenge.common.ApiResponse;
import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.service.IProductService;
import io.swagger.annotations.ApiOperation;
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
    @PostMapping(path = "/add/{productName}")
    public ResponseEntity<ApiResponse> createProduct(@PathVariable(value = "productName") String productName) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(productName);
        if (productService.findProductByName(productDto) == null) {
            productService.save(productDto);
            return new ResponseEntity<>(new ApiResponse("Product has been created."), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponse("Product already exists."), HttpStatus.CONFLICT);
    }

    @ApiOperation(value = "Return the list of all products in DB")
    @GetMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a product by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable(value = "id") Long id) {
        if (productService.findById(id) != null) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(new ApiResponse("Product has been deleted."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("The product does not exists in the DB"), HttpStatus.CONFLICT);
    }

}
