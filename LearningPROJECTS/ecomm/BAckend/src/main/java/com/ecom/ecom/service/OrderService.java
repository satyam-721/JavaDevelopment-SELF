package com.ecom.ecom.service;

import com.ecom.ecom.model.Order;
import com.ecom.ecom.model.OrderItem;
import com.ecom.ecom.model.Product;
import com.ecom.ecom.model.dto.OrderItemRequest;
import com.ecom.ecom.model.dto.OrderItemResponse;
import com.ecom.ecom.model.dto.OrderRequest;
import com.ecom.ecom.model.dto.OrderResponse;
import com.ecom.ecom.repo.OrderRepo;
import com.ecom.ecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderId("ORD"+UUID.randomUUID().toString().substring(0,8).toUpperCase());
        order.setCustomerName(orderRequest.customerName());
        order.setOrderDate(LocalDate.now());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest itemRequest : orderRequest.items()){
            OrderItem orderItem = new OrderItem();

            orderItem.setQuantity(itemRequest.quantity());

            Product product = productRepo.findById(itemRequest.productId())
                    .orElseThrow(() -> new RuntimeException("Product not forund"));
            product.setStockQuantity(product.getStockQuantity()-itemRequest.quantity());

            orderItem.setProduct(product);
            orderItem.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemRequest.quantity())));
            orderItem.setOrder(order);

            orderItems.add(orderItem);

        }
        order.setOrderItems(orderItems);


        Order savedOrder = orderRepo.save(order);

        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for(OrderItem orderItem: savedOrder.getOrderItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                    orderItem.getProduct().getName(),
                    orderItem.getQuantity(),
                    orderItem.getTotalPrice()
            );
            orderItemResponses.add(orderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
                savedOrder.getOrderId(),
                savedOrder.getCustomerName(),
                savedOrder.getEmail(),
                savedOrder.getStatus(),
                savedOrder.getOrderDate(),
                orderItemResponses
        );
        return orderResponse;
    }

    public List<OrderResponse> getAllOrdersResponses() {

        List<Order> orders = orderRepo.findAll();

        List<OrderResponse> orderResponses =  new ArrayList<>();
        for (Order order: orders){
            List<OrderItemResponse> orderItemResponses = new ArrayList<>();
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem: orderItems){

                OrderItemResponse orderItemResponse = new OrderItemResponse(
                        orderItem.getProduct().getName(),
                        orderItem.getQuantity(),
                        orderItem.getTotalPrice()
                );
                orderItemResponses.add(orderItemResponse);

            }



            OrderResponse orderResponse = new OrderResponse(
                    order.getOrderId(),
                    order.getCustomerName(),
                    order.getEmail(),
                    order.getStatus(),
                    order.getOrderDate(),
                    orderItemResponses


            );
            orderResponses.add(orderResponse);
        }


        return orderResponses;
    }
}
