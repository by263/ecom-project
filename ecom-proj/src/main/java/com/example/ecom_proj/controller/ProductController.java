package com.example.ecom_proj.controller;


import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


    @Autowired
    private ProductService service;

    @GetMapping("/products")
    //  Product - type , getallproduct type is list, where list is of type product
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    // @PathVariable => takes value from path i.e id and give to the method parameters(in getProduct)
    public ResponseEntity<Product> getProduct(@PathVariable int id){

        Product product = service.getProductById(id);

        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/product")
    //@RequestPart => when a request includes multiple parts (form data), such as a JSON payload along with a file upload.
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        //multipart - bind complex data to a java object handling files using this
                                        @RequestPart MultipartFile imageFile){
        try{
            System.out.println("");
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}



