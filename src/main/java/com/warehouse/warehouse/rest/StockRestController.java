package com.warehouse.warehouse.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.Dto.StockDto;
import com.warehouse.warehouse.service.StockService;

@RestController
@RequestMapping("/api")
public class StockRestController {

	private StockService stockService;
	
	@Autowired
	public StockRestController(StockService theStockService) {		
		stockService = theStockService;
	}
	
	@GetMapping("/stocks")
	public List<StockDto> findAll(){
		return stockService.findAll();
	}
	
	@GetMapping("/stock/{id}")
	public StockDto findById(@PathVariable int id) {	
		StockDto theStock = stockService.findById(id);	
		if(theStock == null) {
			throw new RuntimeException("Failed to fetch employee with id: "+id);
		}
		return theStock;
	}
	
	@GetMapping("/get-by-date")
	public List<StockDto> findByDate(@RequestBody StockDto dto) {
		List<StockDto> products = stockService.findByDate(dto.getDate(),dto.getProduct());
		return products;
	}
	
	@PostMapping("/stock")
	public StockDto addStock(@RequestBody StockDto theStockDto) {
		stockService.saveStock(theStockDto);
		return theStockDto;
	}
}