package com.lengthConverter.cor.model;

public class ConversionModel {

	private double kilometers;
	private String targetUnit;

	public ConversionModel(double kilometers, String targetUnit) {
	        this.kilometers = kilometers;
	        this.targetUnit = targetUnit.toLowerCase();
	    }

	public double getKilometers() {
		return kilometers;
	}

	public String getTargetUnit() {
		return targetUnit;
	}

}
