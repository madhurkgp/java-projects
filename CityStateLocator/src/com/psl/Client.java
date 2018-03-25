package com.psl;

import java.io.FileNotFoundException;
import java.util.*;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;
import com.util.DataManagerImpl;


public class Client {
	
	public static void main(String[] args) throws FileNotFoundException, InvalidStateException, CityNotFoundException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		DataManagerImpl obj = new DataManagerImpl();
		map= obj.populateCityDataMap("StateCityDetails.txt");
		
		/*List<String> l1 = new ArrayList<String>();
		l1 =  obj.getCities(map,"maharashtra");
		
		for (String string : l1) {
			System.out.println(string);
		}*/
		String str= obj.getState(map, "mumbai");
		
		System.out.println(str);
		
		
	}
}