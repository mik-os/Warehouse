package com.warehouse.warehouse.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.warehouse.warehouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
