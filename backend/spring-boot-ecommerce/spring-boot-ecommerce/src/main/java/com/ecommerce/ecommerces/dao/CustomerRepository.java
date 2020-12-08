package com.ecommerce.ecommerces.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.ecommerces.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
