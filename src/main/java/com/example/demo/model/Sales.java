package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Sales {
    private Long id;
    private String data;
    private String SalesRepresentativeName;
    private String productID;
    private String customerID;

    public Sales() {
    }

    public Sales(Long id, String data, String salesRepresentativeName, String productID, String customerID) {
        this.id = id;
        this.data = data;
        SalesRepresentativeName = salesRepresentativeName;
        this.productID = productID;
        this.customerID = customerID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSalesRepresentativeName() {
        return SalesRepresentativeName;
    }

    public void setSalesRepresentativeName(String salesRepresentativeName) {
        SalesRepresentativeName = salesRepresentativeName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
