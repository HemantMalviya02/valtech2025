package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private WatchRepo watchRepo;
	
	/*
	 * from ownerVO get the Owner
	 * create owner on DB
	 * create ownerVO from Owner
	 * return ownerVO
	 */
	
	@Override
	public OwnerVO createOwner(OwnerVO ownerVO) {
		Owner owner = ownerVO.toOwner();
		owner = ownerRepo.save(owner);
		return OwnerVO.from(owner);
//		return OwnerVO.from(ownerRepo.save(o.toOwner()));
	}
	
	@Override
	public OwnerVO updateOwner(long id, OwnerVO o) {
		Owner owner1 = ownerRepo.getReferenceById(id);
		o.updateOwnerFromVO(owner1);
		return OwnerVO.from(ownerRepo.save(owner1));
	}
	
	@Override
	public OwnerVO getOwner(long id) {
		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}
	
	@Override
	public List<OwnerVO> getOwners() {
		return OwnerVO.toOwnerVO(ownerRepo.findAll());
	}
	
	@Override
	public void deleteOwner(long id) {
		ownerRepo.deleteById(id);
	}

	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
		final Owner owner = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid -> owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1 = ownerRepo.save(owner);
		return OwnerVO.from(owner1);
	}
}
