package com.warehouse.warehouse.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.Dto.WarehouseDto;
import com.warehouse.warehouse.Repository.WarehouseRepository;
import com.warehouse.warehouse.entity.Warehouse;

@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	public WarehouseServiceImpl(WarehouseRepository theWarehouseRepository) {
		warehouseRepository = theWarehouseRepository;
	}
	
	@Override
	public List<WarehouseDto> findAll() {
		List<Warehouse> warehouselist = warehouseRepository.findAll();
		WarehouseDto warehouseDto;
		List<WarehouseDto> warehouseDtolist = new ArrayList<>();
		for(Warehouse warehouse:warehouselist) {
			warehouseDto = entityToDto(warehouse);
			warehouseDtolist.add(warehouseDto);
		}
		return warehouseDtolist;
	}
	
	@Override
	public WarehouseDto findById(int id) {
		Optional<Warehouse> result = warehouseRepository.findById(id);
		Warehouse warehouse = null;
		if(result.isPresent()) {
			warehouse = result.get();
		}else {
			throw new RuntimeException("Cannot fetch warehouse of id -> "+id);
		}
		return entityToDto(warehouse);
	}

	@Override
	public void saveWarehouse (WarehouseDto theWarehouseDto) {
		Warehouse warehouse = new Warehouse();
		warehouse = dtoToEntity(theWarehouseDto);
		warehouseRepository.save(warehouse);
	}
	
	public Warehouse dtoToEntity (WarehouseDto dto) {
		Warehouse warehouse = new Warehouse();
		warehouse.setId(dto.getId());
		warehouse.setName(dto.getName());
		warehouse.setDescription(dto.getDescription());	
		return warehouse; 	
	}
	
	public WarehouseDto entityToDto (Warehouse warehouse) {
		WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setId(warehouse.getId());
        warehouseDto.setName(warehouse.getName());
        warehouseDto.setDescription(warehouse.getDescription());
		return warehouseDto;
	}
}
