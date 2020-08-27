package com.warehouse.warehouse.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.warehouse.warehouse.Dto.BulletinDto;
import com.warehouse.warehouse.Dto.StockDto;
import com.warehouse.warehouse.Repository.BulletinRepository;
import com.warehouse.warehouse.entity.Bulletin;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.Shelf;

enum Types{
	IMPORT,
	EXPORT
}

@Service
public class BulletinServiceImpl implements BulletinService {
	
	private BulletinRepository bulletinRepository;
	StockService stockService;
	
	@Autowired
	public BulletinServiceImpl(BulletinRepository theBulletinRepository, StockService stockService) {
		bulletinRepository = theBulletinRepository;
		this.stockService = stockService;
	}
	
	@Override
	public List<BulletinDto> findAll() {
		List<Bulletin> result = bulletinRepository.findAll();
		BulletinDto dto;
		List<BulletinDto> bulletins = new ArrayList<>();
		for(Bulletin bulletin : result) {
			dto = this.entityToDto(bulletin);
			bulletins.add(dto);
		}
		return bulletins;
	}

	@Override
	public BulletinDto findById(int id) {
		Optional<Bulletin> result = bulletinRepository.findById(id);
		Bulletin bulletin = null;
		if(result.isPresent()) {
			bulletin = result.get();
		}else {
			throw new RuntimeException("Cannot fetch bulletin of id -> "+id);
		}
		return entityToDto(bulletin);
	}

	@Override
	public void saveBulletin(BulletinDto bulletinDto) {
		Bulletin bulletin = new Bulletin();
		bulletin = dtoToEntity(bulletinDto);
		bulletinRepository.saveAndFlush(bulletin);
	}

	@Override
	public List<BulletinDto> findByDate() {
		return null;
	}
	
	public Bulletin dtoToEntity(BulletinDto dto) {
		Bulletin bulletin = new Bulletin();
		bulletin.setDate(dto.getDate());
		bulletin.setEmployee(dto.getEmployee());
		bulletin.setProduct(dto.getProduct());
		bulletin.setQuantity(dto.getQuantity());
		bulletin.setShelf(dto.getShelf());
		bulletin.setId(0);
		bulletin.setType(dto.getType());	
		return bulletin;
	}
	
	public BulletinDto entityToDto(Bulletin bulletin) {
		BulletinDto dto = new BulletinDto();
		dto.setDate(bulletin.getDate());
		dto.setEmployee(bulletin.getEmployee());
		dto.setProduct(bulletin.getProduct());
		dto.setShelf(bulletin.getShelf());
		dto.setQuantity(bulletin.getQuantity());
		dto.setType(bulletin.getType());
		dto.setId(bulletin.getId());
		return dto;
	}

	@Override
	public Bulletin bulletinExists() {
		List<Bulletin> bulletinList = bulletinRepository.bulletinExists();
		Bulletin bulletin = null;
		if (bulletinList.size()>0) {
			bulletin = bulletinList.get(0);
			return bulletin;
		}
		return null;
	}

	public String nextim(Bulletin bulletin) {
		if(bulletin == null){
			return "TIM 1";
		}else {
		   String[] pinakas = bulletin.getTIM().split(" ");  
		   int G = Integer.parseInt(pinakas[1])+1; 
		   pinakas[1]=String.format("%d", G);
		  return String.join(" ",pinakas);
		}	
	}
	 
	@Override
	public void vesa(BulletinDto bulletinDto) throws ParseException {
		Bulletin check = this.bulletinExists();
		String checktim = this.nextim(check);
		this.saveStock(bulletinDto.getProducts(),bulletinDto.getShelf(),bulletinDto.getType(),bulletinDto.getEmployee());
	}
	
	@Override
	public void saveStock(List<Product> products,Shelf shelf,String typeImp,String employee) throws ParseException {
		Bulletin bulletin = this.bulletinExists();
		int quantity = 0;
		for(Product item:products) {
			StockDto st = stockService.stockExists(item,shelf);
			if(st == null ) {
				StockDto newStock = new StockDto();
				if(typeImp.equals("Import")) {
					newStock.setId(0);
					newStock.setProduct(item);
					newStock.setQuantity(item.getUnit());
					newStock.setDate(stockService.toSqlDate());
					newStock.setShelf(shelf);
					stockService.saveStock(newStock);
					Bulletin dto = new Bulletin();
					dto.setId(0);
					dto.setDate(stockService.toSqlDate());
					dto.setEmployee(employee);
					dto.setProduct(item);
					dto.setQuantity(item.getUnit());
					dto.setType(typeImp);
					dto.setTIM(this.nextim(bulletin));
					dto.setShelf(shelf);
					bulletinRepository.save(dto);
				}
				
			}else {
				Boolean check = stockService.checkTypeAndQuantity(st, typeImp, item.getUnit());
				if(check) {
					StockDto stock = new StockDto();
					
					if(typeImp.equals("Import")) {
						quantity = (st.getQuantity() + item.getUnit());
						System.out.println("Item with barcode"+item.getBarcode()+"has quantity of: "+item.getUnit()+"and previous was"+st.getQuantity());
					
						stock.setQuantity(quantity);
						stock.setDate(stockService.toSqlDate());
						stock.setProduct(item);
						stock.setShelf(shelf);
						stock.setId(0);
						stockService.saveStock(stock);
					}else {
						quantity = st.getQuantity() -  item.getUnit();
						stock.setQuantity(quantity);
						stock.setDate(stockService.toSqlDate());
						stock.setProduct(item);
						stock.setShelf(shelf);
						stock.setId(0);
						stockService.saveStock(stock);
					}
					Bulletin dto = new Bulletin();
					dto.setId(0);
					dto.setDate(stockService.toSqlDate());
					dto.setEmployee(employee);
					dto.setProduct(item);
					dto.setQuantity(item.getUnit());
					dto.setType(typeImp);
					dto.setTIM(this.nextim(bulletin));
					dto.setShelf(shelf);
					bulletinRepository.save(dto);
					
				}
			}
		}
	}
}
