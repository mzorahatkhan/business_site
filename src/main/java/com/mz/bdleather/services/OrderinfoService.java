package com.mz.bdleather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.bdleather.dao.OrderinfoRepository;
import com.mz.bdleather.entities.Orderinfo;

@Service
public class OrderinfoService {
	
@Autowired
OrderinfoRepository orderInfoRepo;

//defining save method using orderInfoRep to save entity 
public Orderinfo save(Orderinfo orderInfo)
{
	return orderInfoRepo.save(orderInfo);
}
}
