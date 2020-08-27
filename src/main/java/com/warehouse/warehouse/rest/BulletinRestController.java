package com.warehouse.warehouse.rest;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warehouse.warehouse.Dto.BulletinDto;
import com.warehouse.warehouse.service.BulletinService;
import com.warehouse.warehouse.service.StockService;

@RestController
@RequestMapping("/api")
public class BulletinRestController {

	BulletinService bulletinService;
	StockService stockService;
	
	@Autowired
	public BulletinRestController(BulletinService bulletinService,StockService stockService) {	
		this.bulletinService = bulletinService;
		this.stockService = stockService;
	}
	
	@GetMapping("/bulletin")
	public List<BulletinDto> findAll(){
		return bulletinService.findAll();
	}
	
	@GetMapping("/bulletin/{id}")
	public BulletinDto findById(@PathVariable int id) {
		BulletinDto theBulletin = bulletinService.findById(id);
		if(theBulletin == null) {
			throw new RuntimeException("Failed to fetch employee with id: "+id);
		}
		return theBulletin;
	}
	
	@PostMapping("/bulletin")
	public void saveBulletin(@RequestBody BulletinDto bulletinDto) throws ParseException {
		bulletinService.vesa(bulletinDto);
	}
}