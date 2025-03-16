package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.vos.CustomerVO;

public interface CustomerService {

	CustomerVO saveOrUpdate(CustomerVO cv);

	CustomerVO getCustomer(long id);

	CustomerVO enableCustomer(CustomerVO cv);

	CustomerVO disableCustomer(CustomerVO cv);

	List<CustomerVO> getAll();

}