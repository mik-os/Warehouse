package com.warehouse.warehouse.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.warehouse.warehouse.entity.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {

}

