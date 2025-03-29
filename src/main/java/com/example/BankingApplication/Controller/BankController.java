package com.example.BankingApplication.Controller;

import com.example.BankingApplication.Exception.PUBException;
import com.example.BankingApplication.Model.Customer;
import com.example.BankingApplication.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BankController {

    @Autowired
    private CustomerService service;

    @GetMapping("/Welcome")
    public String hello()
    {
        return "Welcome PoornaSundar Union Bank";
    }

    @GetMapping("/get/customer/{cusName}")
    public Customer getCustomer(@PathVariable String cusName)
    {
        return service.getCustomer(cusName);
    }

    @GetMapping("/get/all/customer")
    public List<Customer> getAllCustomers()
    {
        return service.getAllCustomer();
    }

    @PostMapping("/add/customer")
    public void addCustomer(@RequestBody Customer cus)
    {
        service.addCustomer(cus);
    }

    @PostMapping("/deposit/{cusId}/{amount}")
    public String depositAmount(@PathVariable int cusId, @PathVariable int amount) throws PUBException
    {
        return service.depositAmount(cusId, amount);
    }

    @PostMapping("/withdraw/{cusId}/{amount}")
    public String withdrawAmount(@PathVariable int cusId, @PathVariable int amount) throws PUBException
    {
        return service.withdrawAmount(cusId, amount);
    }

    @PutMapping("/update/customer/{cusId}")
    public void updateCustomer(@PathVariable int cusId, @RequestBody Customer cus) throws PUBException
    {
        service.updateCustomer(cusId, cus);
    }

    @DeleteMapping("/delete/customer/{cusId}")
    public void deleteCustomer(@PathVariable int cusId) throws PUBException
    {
        service.deleteCustomer(cusId);
    }


}
