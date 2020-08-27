package com.warehouse.warehouse.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warehouse.warehouse.Dto.ProductDto;
import com.warehouse.warehouse.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	private ProductService productService;
		
	@Autowired
	public ProductRestController(ProductService theProductService) {		
		productService = theProductService;
	}
		
	@GetMapping("/products")
	public List<ProductDto> findAll(){
		return productService.findAll();
	}
		
	@GetMapping("/product/{id}")
	public ProductDto findById(@PathVariable int id) {	
		ProductDto theProduct = productService.findById(id);	
		if(theProduct == null) {
			throw new RuntimeException("Failed to fetch employee with id: "+id);
		}
			return theProduct;
	}
		
	@PostMapping("/product")
	public ProductDto addProduct(@RequestBody ProductDto theProductDto) {
		productService.saveProduct(theProductDto);
		return theProductDto;
	}

}
