package com.warehouse.warehouse.service;
import java.util.List;
import com.warehouse.warehouse.Dto.ShelfDto;

public interface ShelfService {

	public List<ShelfDto> findAll();
	public void saveShelf(ShelfDto theShelfDto);
	public ShelfDto findById(int id);
}
