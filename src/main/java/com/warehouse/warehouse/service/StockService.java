package com.warehouse.warehouse.service;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.warehouse.warehouse.Dto.StockDto;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;

public interface StockService {
	
	public List<StockDto> findAll();
	public void saveStock(StockDto theStockDto);
	public StockDto findById(int id);
	public StockDto stockExists(Product barcode,Shelf shelf);
	public Boolean checkTypeAndQuantity(StockDto stockDto,String type,int quantity);
	public Date toSqlDate() throws ParseException;
	public List<StockDto> findByDate(Date date,Product product);
}
