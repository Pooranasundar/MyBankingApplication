package com.example.BankingApplication.Service;

import com.example.BankingApplication.Exception.PUBException;
import com.example.BankingApplication.Model.Customer;
import com.example.BankingApplication.Repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private BankRepo repo;

    public Customer getCustomer(String cusName)
    {
        return repo.findByCustomerName(cusName);
    }

    public List<Customer> getAllCustomer()
    {
        return repo.findAll();
    }

    public void addCustomer(Customer cus)
    {
        repo.save(cus);
    }

    public String depositAmount(int cusId, int amount) throws PUBException
    {
        Customer cus = repo.findById(cusId).orElseThrow(() -> new PUBException("Customer ID is Not Found"));
        cus.setBalance(cus.getBalance() + amount);
        repo.save(cus);

        return "Deposit Successfully";
    }

    public String withdrawAmount(int cusId, int amount) throws PUBException
    {
        Customer cus = repo.findById(cusId).orElseThrow(() -> new PUBException("Customer ID is Not Found"));
        if(cus.getBalance() < amount)
            return "Your Withdraw amount is less than your Balance";

        cus.setBalance(cus.getBalance() - amount);
        repo.save(cus);

        return "Withdrawal Successfully";
    }

    public void updateCustomer(int cusId, Customer cus) throws PUBException
    {
        Customer customer = repo.findById(cusId).orElseThrow(() -> new PUBException("Customer ID is Not Found"));
        customer.setCustomerName(cus.getCustomerName());
        customer.setBankBranch(cus.getBankBranch());
        customer.setBalance(cus.getBalance());

        repo.save(customer);
    }

    public void deleteCustomer(int cusId) throws PUBException
    {
        Customer id = repo.findById(cusId).orElseThrow(() -> new PUBException("Customer is Not Found"));
        int deleteId = id.getCustomerId();
        repo.deleteById(deleteId);
    }

}
