package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO o);

	OwnerVO updateOwner(long id, OwnerVO o);

	OwnerVO getOwner(long id);
	
	void deleteOwner(long id);

	List<OwnerVO> getOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}