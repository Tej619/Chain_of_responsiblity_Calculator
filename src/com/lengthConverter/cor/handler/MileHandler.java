package com.lengthConverter.cor.handler;

import com.lengthConverter.cor.model.ConversionModel;

public class MileHandler extends Handler {
	private static final double KM_TO_MILE = 0.621371;
	
	@Override
	public String handleRequest(ConversionModel request) {
		if ("mile".equals(request.getTargetUnit())) {
			double result = request.getKilometers() * KM_TO_MILE; // 1 km = 0.621371 miles
			return String.format("%.2f km is %.5f miles", request.getKilometers(), result);
		} else if (successor != null) {
			return successor.handleRequest(request);
		}
		return "Invalid unit Enter again";
	}
}