package com.warehouse.warehouse.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.warehouse.warehouse.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
	
}
