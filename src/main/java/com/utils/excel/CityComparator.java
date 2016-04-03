package com.utils.excel;
import java.util.Comparator;


public class CityComparator implements Comparator<City> {

	public int compare(City o1, City o2) {
		Double revenue1 = o1.getTotalRevenue();
		Double revenue2 = o2.getTotalRevenue();

       return revenue2.compareTo(revenue1);
	}

}
