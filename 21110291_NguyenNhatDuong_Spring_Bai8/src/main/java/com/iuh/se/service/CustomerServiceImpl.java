package com.iuh.se.service;

import com.iuh.se.dao.CustomerDAO;
import com.iuh.se.entities.Customer;
import com.iuh.se.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        return customerRepository.findById((long) theId).get();
    }

    @Override
    public void deleteCustomer(int theId) {
        customerRepository.deleteById((long) theId);
    }
}
