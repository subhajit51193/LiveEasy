package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.PayLoad;
import com.app.exception.PayLoadException;
import com.app.repository.PayLoadRepository;

@Service
public class PayLoadServiceImpl implements PayLoadService{
	
	@Autowired
	private PayLoadRepository payLoadRepository;

	@Override
	public PayLoad createPayLoad(PayLoad payLoad) {
		
		String randomId = UUID.randomUUID().toString();
		payLoad.setShipperId(randomId);
		return payLoadRepository.save(payLoad); 
	}

	@Override
	public PayLoad getPayLoadById(Integer payLoadId) throws PayLoadException {
		
		Optional<PayLoad> opt = payLoadRepository.findById(payLoadId);
		if (opt.isPresent()) {
			PayLoad payLoad = opt.get();
			return payLoad;
		}
		else {
			throw new PayLoadException("Not found");
		}
	}

	@Override
	public List<PayLoad> getPayLoadByShipperId(String shipperId) throws PayLoadException {
		
		List<PayLoad> list = payLoadRepository.findByShipperId(shipperId);
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new PayLoadException("Not found");
		}
	}

	@Override
	public PayLoad updatePayLoad(Integer payLoadId, PayLoad payLoad) throws PayLoadException {
		
		Optional<PayLoad> opt = payLoadRepository.findById(payLoadId);
		if (opt.isPresent()) {
			PayLoad found = opt.get();
			found.setLoadingPoint(payLoad.getLoadingPoint());
			found.setNumberOfTrucks(payLoad.getNumberOfTrucks());
			found.setProductType(payLoad.getProductType());
			found.setShipperId(payLoad.getShipperId());
			found.setTruckType(payLoad.getTruckType());
			found.setWeight(payLoad.getWeight());
			found.setComment(payLoad.getComment());
			found.setDate(payLoad.getDate());
			return payLoadRepository.save(found);
		}
		else {
			throw new PayLoadException("Not found");
		}
	}

	@Override
	public PayLoad deletePayLoad(Integer payLoadId) throws PayLoadException {
		
		Optional<PayLoad> opt = payLoadRepository.findById(payLoadId);
		if (opt.isPresent()) {
			PayLoad payLoad = opt.get();
			payLoadRepository.delete(payLoad);
			return payLoad;
		}
		else {
			throw new PayLoadException("Not found");
		}
	}

}
