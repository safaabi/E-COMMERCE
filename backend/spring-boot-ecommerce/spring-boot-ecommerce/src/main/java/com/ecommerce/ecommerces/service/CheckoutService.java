package com.ecommerce.ecommerces.service;

import com.ecommerce.ecommerces.dto.Purchase;
import com.ecommerce.ecommerces.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
