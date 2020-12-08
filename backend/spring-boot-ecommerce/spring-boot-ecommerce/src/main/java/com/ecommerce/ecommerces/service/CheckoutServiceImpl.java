package com.ecommerce.ecommerces.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.ecommerces.dao.CustomerRepository;
import com.ecommerce.ecommerces.dto.Purchase;
import com.ecommerce.ecommerces.dto.PurchaseResponse;
import com.ecommerce.ecommerces.entities.Customer;
import com.ecommerce.ecommerces.entities.Order;
import com.ecommerce.ecommerces.entities.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		  // retrieve the order info from dto
		  Order order = purchase.getOrder();
		  //generate tracking number
		  String orderTrackingNumber = generateOrderTrackingNumber();
		  order.setOrderTrackingNumber(orderTrackingNumber);
		  //populate order with orderitems
		  Set<OrderItem> orderItems = purchase.getOrderItems();
		  orderItems.forEach(item -> order.add(item));
		  
		  //populate order with billingAddress and shippingAddress
		  order.setBillingAddress(purchase.getBillingAddress());
		  order.setShippingAddress(purchase.getShippingAddress());
		  
		  //populate customer with order
		  Customer customer = purchase.getCustomer();
		  customer.add(order);
		  
		  //save to db
		  customerRepository.save(customer);
		  //return response
		  return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		// generate a random UUID number
		return UUID.randomUUID().toString();
	}

}
