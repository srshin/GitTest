package com.encore.day18_6;

import java.util.ArrayList;

public class SeatListDTO {

	ArrayList<String> seatList;

	public SeatListDTO(ArrayList<String> seatList) {
		super();
		this.seatList = seatList;
	}

	@Override
	public String toString() {
		return "SeatListDTO [seatList=" + seatList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seatList == null) ? 0 : seatList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatListDTO other = (SeatListDTO) obj;
		if (seatList == null) {
			if (other.seatList != null)
				return false;
		} else if (!seatList.equals(other.seatList))
			return false;
		return true;
	}
	
	
	
}
