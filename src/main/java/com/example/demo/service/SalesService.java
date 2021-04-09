package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Sales;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SalesService {
    @Autowired
    private SalesRepository repository;
    //Date date = new Date(System.currentTimeMillis());

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

    public List<Sales> listAll(){
        return repository.findAll();
    }
    public  List<Sales> getCertainSales(){
        List<Sales> certainSales = new ArrayList<>();
        for (Sales sales: listAll()){
            if(sales.getSalesRepresentativeName().equals(getUserName())){
                certainSales.add(sales);
            }
        }
        return certainSales;
    }

    public void save(Sales sales) {
        Sales sales1 = new Sales(sales.getId(), sales.getData() , getUserName(), sales.getProductID(), sales.getCustomerID());
        repository.save(sales1);
    }

    public Sales get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Sales> findBySalesRepresentativeName(String keyword){
        return repository.findBySalesRepresentativeName(keyword);
    }
}

