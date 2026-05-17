package com.ecom.ecom.controllers;

import com.ecom.ecom.model.dto.OrderItemResponse;
import com.ecom.ecom.model.dto.OrderRequest;
import com.ecom.ecom.model.dto.OrderResponse;
import com.ecom.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api")
public class OrderController {


    @Autowired
    OrderService service;

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){

        System.out.println( 
                "Method called"
        );

        OrderResponse orderResponse = service.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> orderResponses = service.getAllOrdersResponses();
        return new ResponseEntity<>(orderResponses,HttpStatus.OK);
    }
}
