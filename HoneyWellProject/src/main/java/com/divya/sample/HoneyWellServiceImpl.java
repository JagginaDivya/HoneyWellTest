package com.divya.sample;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoneyWellServiceImpl {

	@Autowired
	HoneyWellRepository honeyWellRepository;

	
	
	public List<HoneyWell> getAllFilledSeatNumbers()
	{
		return (List<HoneyWell>) honeyWellRepository.findAll();
	}
	
	
	public void save(HoneyWell honeyWell) {
		
		honeyWellRepository.save(honeyWell);
	}
	
	public void validate(String selectedMovie, int selectedSeat) {
		// TODO Auto-generated method stub
		
		List<HoneyWell> userSelected =new ArrayList<>();
		int position =isSeatAvailable(selectedMovie,selectedSeat);
		if(position!=-1)
		{
			userSelected.get(position).setSeatNo(selectedSeat);
			userSelected.get(position).setMoviename(selectedMovie);
	
				save((HoneyWell) userSelected);
		}
	}
	
	private int isSeatAvailable(String selectedMovie, int selectedSeat) {
		// TODO Auto-generated method stub
		List<HoneyWell> movieDataHoneyWells = getAllFilledSeatNumbers();
		int positionAvailable=-1;
		for(int i=0;i<movieDataHoneyWells.size();i++)
		{
			if(selectedSeat == movieDataHoneyWells.get(i).getSeatNo() && ( selectedMovie == movieDataHoneyWells.get(i).getMoviename()))
			{
				positionAvailable=i;
				return positionAvailable;
			}
		}
		return positionAvailable;
	
	}
}
