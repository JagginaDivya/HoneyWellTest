package com.divya.sample;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoneyWellController {

	@Autowired
	HoneyWellServiceImpl honeyWellServiceImpl;
	List<String> seatList= new ArrayList<>();
	
	@PostMapping("/validate")
	public String validate(@RequestParam(defaultValue = "empty") String selectedMovie, @RequestParam(defaultValue = "empty") Integer selectedSeat)
	{
		System.out.print("invoked validate"+selectedMovie+" "+selectedSeat);
			honeyWellServiceImpl.validate(selectedMovie,selectedSeat);
		
		return null;
	}
	
	
	
	@GetMapping("displaySeats")
	public List<HoneyWell> DisplayAllSeats()
	{System.out.print("invoked display");
	
		return ((HoneyWellServiceImpl) honeyWellServiceImpl).getAllFilledSeatNumbers();
	
	}
	
}
