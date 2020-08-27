package com.warehouse.warehouse.service;
import java.util.List;
import com.warehouse.warehouse.Dto.ProductDto;

public interface ProductService {

	public List<ProductDto> findAll();
	public void saveProduct(ProductDto theProductDto);
	public ProductDto findById(int id);
}
