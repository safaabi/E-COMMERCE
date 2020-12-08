package com.ecommerce.ecommerces.dto;

import java.util.Set;

import com.ecommerce.ecommerces.entities.Address;
import com.ecommerce.ecommerces.entities.Customer;
import com.ecommerce.ecommerces.entities.Order;
import com.ecommerce.ecommerces.entities.OrderItem;

import lombok.Data;

@Data
public class Purchase {
      private Customer customer;
      private Address shippingAddress; 
      private Address billingAddress;
      private Order order;
      private Set<OrderItem> orderItems;
      
      
}
