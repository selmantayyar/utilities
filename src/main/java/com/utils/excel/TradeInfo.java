package com.utils.excel;
import java.util.ArrayList;
import java.util.List;


public class TradeInfo {
	
	private String name;
	private List <City> cityList=new ArrayList<City>();
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result="Name: "+this.getName()+" Revenue TY: "+this.getMarketRevenueTY()+" Revenue LY: "+this.getMarketRevenueLY()
		+" averageMarketRevenueTY: "+this.getAverageMarketRevenueTY()+" averageMarketRevenueLY: "+this.getAverageMarketRevenueLY();
		return result;
		
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getMarketRevenueTY() {
		return marketRevenueTY;
	}
	public void setMarketRevenueTY(double marketRevenueTY) {
		this.marketRevenueTY = marketRevenueTY;
	}
	public double getMarketRevenueLY() {
		return marketRevenueLY;
	}
	public void setMarketRevenueLY(double marketRevenueLY) {
		this.marketRevenueLY = marketRevenueLY;
	}
	public double getAverageMarketRevenueTY() {
		return averageMarketRevenueTY;
	}
	public void setAverageMarketRevenueTY(double averageMarketRevenueTY) {
		this.averageMarketRevenueTY = averageMarketRevenueTY;
	}
	public double getAverageMarketRevenueLY() {
		return averageMarketRevenueLY;
	}
	public void setAverageMarketRevenueLY(double averageMarketRevenueLY) {
		this.averageMarketRevenueLY = averageMarketRevenueLY;
	}

	private double marketRevenueTY;
	private double marketRevenueLY;
	private double averageMarketRevenueTY;
	private double averageMarketRevenueLY;
	private double totalMarketRevenueTY;
	private double totalMarketRevenueLY;
	private String destinationCity;
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public double getTotalMarketRevenueTY() {
		return totalMarketRevenueTY;
	}
	public void setTotalMarketRevenueTY(double totalMarketRevenueTY) {
		this.totalMarketRevenueTY = totalMarketRevenueTY;
	}
	public double getTotalMarketRevenueLY() {
		return totalMarketRevenueLY;
	}
	public void setTotalMarketRevenueLY(double totalMarketRevenueLY) {
		this.totalMarketRevenueLY = totalMarketRevenueLY;
	}
	

}
