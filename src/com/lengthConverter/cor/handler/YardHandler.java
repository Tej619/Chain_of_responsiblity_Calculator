package com.lengthConverter.cor.handler;

import com.lengthConverter.cor.model.ConversionModel;

public class YardHandler extends Handler {
	private static final double KM_TO_YARD = 1093.61;

	@Override
	public String handleRequest(ConversionModel request) {
		if ("yard".equals(request.getTargetUnit())) {
			double result = request.getKilometers() * KM_TO_YARD; // 1 km = 1093.61 yards
			return String.format("%.2f km is %.5f yards", request.getKilometers(), result);
		} else if (successor != null) {
			return successor.handleRequest(request);
		}
		return "Invalid unit Enter again";
	}
}
