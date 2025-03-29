package com.example.BankingApplication.Repository;

import com.example.BankingApplication.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Customer, Integer> {

    Customer findByCustomerName(String customerName);
}
