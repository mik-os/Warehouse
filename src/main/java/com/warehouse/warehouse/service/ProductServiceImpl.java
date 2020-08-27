package com.warehouse.warehouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.Dto.ProductDto;
import com.warehouse.warehouse.Repository.ProductRepository;
import com.warehouse.warehouse.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}
	
	@Override
	public List<ProductDto> findAll() {
		List<Product> productlist = productRepository.findAll();
		ProductDto productDto;
		List<ProductDto> productDtolist = new ArrayList<>();
		for(Product product:productlist) {
			productDto = entityToDto(product);
			productDtolist.add(productDto);
		}		
		return productDtolist;
	}
	
	@Override
	public ProductDto findById(int id) {
		Optional<Product> result = productRepository.findById(id);
		Product product = null;
		if(result.isPresent()) {
			product = result.get();
		}else {
			throw new RuntimeException("Cannot fetch product of id -> "+id);
		}
		return entityToDto(product);
	}

	@Override
	public void saveProduct (ProductDto theProductDto) {
		Product product = new Product(0, null, 0);
		product = dtoToEntity(theProductDto);
		productRepository.save(product);
	}
	
	public Product dtoToEntity (ProductDto dto) {
		Product product = new Product(0, null, 0);
		product.setBarcode(dto.getBarcode());
		product.setDescription(dto.getDescription());
		product.setUnit(dto.getUnit());
		return product; 	
	}
	
	public ProductDto entityToDto (Product product) {
		ProductDto productDto = new ProductDto(0, null,0);
		productDto.setBarcode(product.getBarcode());
		productDto.setDescription(product.getDescription());		
		productDto.setUnit(product.getUnit());
		return productDto;
	}
	
}	