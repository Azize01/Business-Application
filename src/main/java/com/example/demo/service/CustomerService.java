package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private  CustomerRepository repository;


    public static String getUserName() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userName = userDetails.getUsername();

        }
        return userName;
    }

    public List<Customer> listAll(){
        return repository.findAll();
    }
    public  List<Customer> getCertainCustomers (){
        List<Customer> certainCustomers = new ArrayList<>();
        for (Customer customer: listAll()){
            if(customer.getSalesRepresentativeName().equals(getUserName())){
                certainCustomers.add(customer);
            }
        }
        return certainCustomers;
    }

    public void save(Customer customer) {
        Customer customer1 = new Customer(customer.getId(),customer.getFullName(),getUserName(), customer.getAge());
        repository.save(customer1);
    }

    public Customer get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
