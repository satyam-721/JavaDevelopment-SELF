package com.ecom.ecom.controllers;


import com.ecom.ecom.model.Product;
import com.ecom.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
        Product product= service.getProduct(productId);
        if (product != null){
            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int productId){

        Product product = service.getProduct(productId);


        if (product != null){
            return new ResponseEntity<>(product.getImageData(), HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping("/product")
    //we are not getting whole RequestBody in one ,
    //accepting the json and image data sepratly
    //we are seprating image from data. (we are technically dividing RequestBody in multiple parts)

    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {

        System.out.println("RAW product: " + product);
        System.out.println();
        System.out.println("Image File:" +imageFile);

        try {
            Product pro = service.addOrUpdateProduct(product,imageFile);
            return new ResponseEntity<>(pro,HttpStatus.ACCEPTED);
        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,
                                           @RequestPart("product") Product product,
                                           @RequestPart("imageFile") MultipartFile imageFile){

        try{
            Product updateproduct = service.addOrUpdateProduct(product,imageFile);
            return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        try{
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch(Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){

        List<Product> products = service.searchProducts(keyword);
        System.out.println("Searching for Keyword:"+keyword+products);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }



}




