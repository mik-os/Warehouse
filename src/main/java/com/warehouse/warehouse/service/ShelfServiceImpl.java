package com.warehouse.warehouse.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warehouse.warehouse.Dto.ShelfDto;
import com.warehouse.warehouse.Repository.ShelfRepository;
import com.warehouse.warehouse.entity.Shelf;

@Service
public class ShelfServiceImpl implements ShelfService {
	
	private ShelfRepository shelfRepository;
	
	@Autowired
	public ShelfServiceImpl(ShelfRepository theShelfRepository) {
		shelfRepository = theShelfRepository;
	}
	
	@Override
	public List<ShelfDto> findAll() {
		List<Shelf> shelflist = shelfRepository.findAll();
		ShelfDto shelfDto;
		List<ShelfDto> shelfDtolist = new ArrayList<>();
		for(Shelf shelf:shelflist) {
			shelfDto = entityToDto(shelf);
			shelfDtolist.add(shelfDto);
		}		
		return shelfDtolist;
	}
	
	@Override
	public ShelfDto findById(int id) {
		Optional<Shelf> result = shelfRepository.findById(id);
		Shelf shelf = null;
		if(result.isPresent()) {
			shelf = result.get();
		}else {
			throw new RuntimeException("Cannot fetch product of id -> "+id);
		}
		return entityToDto(shelf);
	}

	@Override
	public void saveShelf (ShelfDto theShelfDto) {
		Shelf shelf = new Shelf();
		shelf = dtoToEntity(theShelfDto);
		shelfRepository.save(shelf);
	}
	
	public Shelf dtoToEntity (ShelfDto dto) {
		Shelf shelf = new Shelf();
		shelf.setId(dto.getId());
		shelf.setDescription(dto.getDescription());
		shelf.setWarehouse(dto.getWarehouse());
		return shelf; 	
	}
	
	public ShelfDto entityToDto (Shelf shelf) {
		ShelfDto shelfDto = new ShelfDto();
		shelfDto.setId(shelf.getId());
		shelfDto.setDescription(shelf.getDescription());		
		shelfDto.setWarehouse(shelf.getWarehouse());
		return shelfDto;
	}
	
}