package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PayLoad;
import com.app.exception.PayLoadException;
import com.app.service.PayLoadService;

@RestController
@RequestMapping("/load")
public class PayLoadController {

	@Autowired
	private PayLoadService payLoadService;
	
	@PostMapping()
	public ResponseEntity<PayLoad> createPayLoadHandler(@RequestBody PayLoad payLoad){
		
		PayLoad newPayLoad = payLoadService.createPayLoad(payLoad);
		return new ResponseEntity<PayLoad>(newPayLoad,HttpStatus.CREATED);
	}
	
	@GetMapping("/{loadId}")
	public ResponseEntity<PayLoad> getByPayLoadIdHandler(@PathVariable("loadId") Integer loadId) throws PayLoadException{
		
		PayLoad payLoad = payLoadService.getPayLoadById(loadId);
		return new ResponseEntity<PayLoad>(payLoad,HttpStatus.ACCEPTED);
	}
	
	@GetMapping()
	public ResponseEntity<List<PayLoad>> getByShipperIdHandler(@RequestParam String shipperId) throws PayLoadException{
	
		List<PayLoad> list = payLoadService.getPayLoadByShipperId(shipperId);
		return new ResponseEntity<List<PayLoad>>(list,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{loadId}")
	public ResponseEntity<PayLoad> updateHandler(@PathVariable("loadId") Integer loadId, @RequestBody PayLoad payLoad) throws PayLoadException{
		
		PayLoad updated = payLoadService.updatePayLoad(loadId, payLoad);
		return new ResponseEntity<PayLoad>(updated,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{loadId}")
	public ResponseEntity<PayLoad> deleteHandler(@PathVariable("loadId") Integer loadId) throws PayLoadException{
		
		PayLoad deletedPayLoad = payLoadService.deletePayLoad(loadId);
		return new ResponseEntity<PayLoad>(deletedPayLoad,HttpStatus.ACCEPTED);
	}
}
