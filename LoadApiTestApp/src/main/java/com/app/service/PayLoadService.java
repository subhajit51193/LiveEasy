package com.app.service;

import java.util.List;

import com.app.entity.PayLoad;
import com.app.exception.PayLoadException;

public interface PayLoadService {

	public PayLoad createPayLoad(PayLoad payLoad);
	
	public PayLoad getPayLoadById(Integer payLoadId)throws PayLoadException;
	
	public List<PayLoad> getPayLoadByShipperId(String shipperId)throws PayLoadException;
	
	public PayLoad updatePayLoad(Integer payLoadId, PayLoad payLoad)throws PayLoadException;
	
	public PayLoad deletePayLoad(Integer payLoadId)throws PayLoadException;
}
