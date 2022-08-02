package com.divya.sample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HoneyWell {

	@Id
	private int id;
	private String moviename;
	private int seatNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
