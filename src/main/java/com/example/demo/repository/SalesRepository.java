package com.example.demo.repository;

import com.example.demo.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    @Query(value = "SELECT * FROM users.sales WHERE sales_representative_name like:keyword", nativeQuery = true)
    List<Sales> findBySalesRepresentativeName (@Param("keyword") String keyword);

}
