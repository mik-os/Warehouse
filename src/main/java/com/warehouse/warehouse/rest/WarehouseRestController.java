package com.warehouse.warehouse.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.Dto.WarehouseDto;
import com.warehouse.warehouse.service.WarehouseService;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {

	private WarehouseService warehouseService;
	
	@Autowired
	public WarehouseRestController(WarehouseService theWarehouseService) {		
		warehouseService = theWarehouseService;
	}
	
	@GetMapping("/warehouses")
	public List<WarehouseDto> findAll(){
		return warehouseService.findAll();
	}
	
	@GetMapping("/warehouse/{id}")
	public WarehouseDto findById(@PathVariable int id) {
		
		WarehouseDto theWarehouse = warehouseService.findById(id);
		
		if(theWarehouse == null) {
			throw new RuntimeException("Failed to fetch employee with id: "+id);
		}
		return theWarehouse;
	}
	
	@PostMapping("/warehouse")
	public WarehouseDto addWarehouse(@RequestBody WarehouseDto theWarehouseDto) {
		warehouseService.saveWarehouse(theWarehouseDto);
		return theWarehouseDto;
	}
}
