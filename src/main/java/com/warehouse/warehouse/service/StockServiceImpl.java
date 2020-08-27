package com.warehouse.warehouse.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.Dto.StockDto;
import com.warehouse.warehouse.Repository.StockRepository;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.entity.Stock;

@Service
public class StockServiceImpl implements StockService {

	private StockRepository stockRepository;
	
	@Autowired
	public StockServiceImpl(StockRepository stockRepository) {
		this.stockRepository=stockRepository;
	}
	
	@Override
	public List<StockDto> findAll() {
		List<Stock> results = this.stockRepository.findAll();
		StockDto dto;
		List<StockDto> stocks = new ArrayList<>();
		for(Stock stock : results) {
			dto = this.entityToDto(stock);
			stocks.add(dto);
		}
		return stocks;
	}

	@Override
	public void saveStock(StockDto theStockDto) {
		Stock stock  = new Stock();
		stock = dtoToEntity(theStockDto);
		stockRepository.save(stock);
	}
	
	@Override
	public List<StockDto> findByDate(Date date, Product product) {
		List<Stock> result = stockRepository.findByDate(date, product);
		List<StockDto> dto = new ArrayList<>();
		for(Stock st:result) {
			dto.add(entityToDto(st));
		}
		return dto;
	}
	
	public Stock dtoToEntity (StockDto dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setDate(dto.getDate());
		stock.setProduct(dto.getProduct());	
		stock.setShelf(dto.getShelf());
		stock.setQuantity(dto.getQuantity());
		return stock; 	
	}
	
	public StockDto entityToDto (Stock stock) {
		StockDto stockDto = new StockDto();
		stockDto.setId(stock.getId());
		stockDto.setDate(stock.getDate());
		stockDto.setProduct(stock.getProduct());
		stockDto.setShelf(stock.getShelf());
		stockDto.setQuantity(stock.getQuantity());
		return stockDto;
	}

	@Override
	public StockDto stockExists(Product barcode, Shelf shelf) {
		
		
		List<Stock> stocks = stockRepository.stockExists(barcode, shelf);
		if(stocks.size()>0) {
			return entityToDto(stocks.get(0));
		}
		
		return null;
	}
	
	@Override
	public Date toSqlDate() throws ParseException {
 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime ldt = LocalDateTime.now();
		String now = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt); 
		Date date = formatter.parse(now);
		return date;
	}
	
	@Override
	public Boolean checkTypeAndQuantity(StockDto stockDto,String type,int quantity) {
		if(quantity <= 0) {
			return false;
		}
		if( stockDto.getQuantity() == 0 && type.equals("Export")) {
			return false;
		}
		if (type.equals("Export")  && (stockDto.getQuantity() - quantity < 0) ) {
			return false;
		}
		return true;
	}
	
	@Override
	public StockDto findById(int id) {
		return null;
	}
}
