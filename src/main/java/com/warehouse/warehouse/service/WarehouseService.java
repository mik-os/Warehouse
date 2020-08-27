package com.warehouse.warehouse.service;
import java.util.List;
import com.warehouse.warehouse.Dto.WarehouseDto;

public interface WarehouseService {

	public List<WarehouseDto> findAll();
	public void saveWarehouse(WarehouseDto theWarehouseDto);
	public WarehouseDto findById(int id);
}
