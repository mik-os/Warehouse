package com.warehouse.warehouse.service;
import java.text.ParseException;
import java.util.List;

import com.warehouse.warehouse.Dto.BulletinDto;
import com.warehouse.warehouse.entity.Bulletin;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;

public interface BulletinService {

	public List<BulletinDto> findAll();
	public BulletinDto findById(int id);
	public void saveBulletin(BulletinDto bulletinDto);
	public List<BulletinDto> findByDate();
	public Bulletin bulletinExists();
	public void vesa(BulletinDto bulletinDto) throws ParseException;
	public void saveStock(List<Product> products, Shelf shelf, String typeImp, String employee) throws ParseException;
	
}
