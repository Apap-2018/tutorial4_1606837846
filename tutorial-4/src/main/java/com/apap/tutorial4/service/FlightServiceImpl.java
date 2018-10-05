package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.FlightDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void deleteFlight(String flightNumber) {
		flightDb.delete(this.getFlightDetailByFlightNumber(flightNumber));
	}
	
	@Override
	public void updateFlight(String flightNumber, FlightModel newFlight) {
		FlightModel flightLama = this.getFlightDetailByFlightNumber(flightNumber);
		flightLama.setFlightNumber(newFlight.getFlightNumber());
		flightLama.setOrigin(newFlight.getOrigin());
		flightLama.setDestination(newFlight.getDestination());
		flightLama.setTime(newFlight.getTime());
	}
}
