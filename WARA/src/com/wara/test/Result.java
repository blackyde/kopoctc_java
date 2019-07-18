package com.wara.test;

public class Result {
	private String placeName;
	private double distance;
	
	public Result() {
		
	}
	
	public Result(String placeName, double distance) {
		this.placeName = placeName;
		this.distance = distance;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public double getDist() {
		return distance;
	}
	public void setDist(double distance) {
		this.distance = distance;
	}
}
