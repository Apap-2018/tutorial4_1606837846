package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;

/*
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(String flightNumber, FlightModel flight);
}
