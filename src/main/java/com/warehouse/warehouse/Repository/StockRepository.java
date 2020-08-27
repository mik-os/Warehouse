package com.warehouse.warehouse.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
		
	@Query("From Stock where barcode=?1 AND shelf=?2 ORDER BY id DESC")
	List<Stock> stockExists(Product barcode,Shelf shelf);
	
	@Query("From Stock where date<=?1 AND barcode=?2")
	List<Stock> findByDate(Date date,Product product);
	
}
