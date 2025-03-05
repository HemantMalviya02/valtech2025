package com.valtech.training.restapis.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.vos.WatchVO;

@Repository
public interface WatchRepo extends JpaRepository<Watch, Long>{

	List<Watch> findAllByBrand(String brand);
	
}
