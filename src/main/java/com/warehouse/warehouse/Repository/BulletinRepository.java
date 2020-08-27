package com.warehouse.warehouse.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.warehouse.warehouse.entity.Bulletin;

public interface BulletinRepository extends JpaRepository<Bulletin, Integer> {
	
	@Query(nativeQuery=true,value="Select * from bulletin order by id DESC limit 1")
	List<Bulletin> bulletinExists();
	
}
