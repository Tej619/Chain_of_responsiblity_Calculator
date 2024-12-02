package com.lengthConverter.cor.handler;

import com.lengthConverter.cor.model.*;
public abstract class Handler {
	protected Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract String handleRequest(ConversionModel request);
}