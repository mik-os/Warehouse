package com.warehouse.warehouse.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warehouse.warehouse.Dto.ShelfDto;
import com.warehouse.warehouse.service.ShelfService;
import com.warehouse.warehouse.service.WarehouseService;

@RestController
@RequestMapping("/api")
public class ShelfRestController {
	
	private ShelfService shelfService;
	private WarehouseService warehouseService;
		
	@Autowired
	public ShelfRestController(ShelfService theShelfService, WarehouseService warehouseService) {		
		shelfService = theShelfService;
		this.warehouseService=warehouseService;
	}
		
	@GetMapping("/shelves")
	public List<ShelfDto> findAll(){
		return shelfService.findAll();
	}
		
	@GetMapping("/shelf/{id}")
	public ShelfDto findById(@PathVariable int id) {	
		ShelfDto theShelf = shelfService.findById(id);	
		if(theShelf == null) {
			throw new RuntimeException("Failed to fetch shelf with id: "+id);
		}
			return theShelf;
	}
		
	@PostMapping("/shelf")
	public ShelfDto addShelf(@RequestBody ShelfDto theShelfDto) {
        warehouseService.findById(theShelfDto.getWarehouse().getId());
//		WarehouseDto warehouse = warehouseService.findById(theShelfDto.getWarehouse().getId());
		shelfService.saveShelf(theShelfDto);
		return theShelfDto;
	}
}