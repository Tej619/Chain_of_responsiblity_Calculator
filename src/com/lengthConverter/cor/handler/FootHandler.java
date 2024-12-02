package com.lengthConverter.cor.handler;

import com.lengthConverter.cor.model.ConversionModel;

public class FootHandler extends Handler {
	private static final double KM_TO_FOOT = 3280.84;

	@Override
	public String handleRequest(ConversionModel request) {
		if ("foot".equals(request.getTargetUnit())) {
			double result = request.getKilometers() * KM_TO_FOOT; // 1 km = 3280.84 feet
			return String.format("%.2f km is %.5f feet", request.getKilometers(), result);
		} else if (successor != null) {
			return successor.handleRequest(request);
		}
		return "Invalid unit Enter again";
	}
}
