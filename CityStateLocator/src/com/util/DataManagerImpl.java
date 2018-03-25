package com.util;

import java.io.*;
import java.util.*;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;


// Override and implement the methods of Interface DataManager here 
public class DataManagerImpl implements DataManager {

	
	@Override
	public Map<String, List<String>> populateCityDataMap(String fileName)
			throws FileNotFoundException {
		File f1 = new File(fileName);
		Scanner sc = new Scanner(f1);
		Map<String,List<String>> map = new HashMap<>();
		List<String> l1 = null;
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			String line1[];
			line1 = line.split("-");
			
			
			if(map.containsKey(line1[0]))
			{
				l1=map.get(line1[0]);
				l1.add(line1[1]);
				map.put(line1[0],l1);
			}
			else
			{
				l1 = new ArrayList<>();
				l1.add(line1[1]);
				map.put(line1[0], l1);
			}
		}
		
		return map;
	}

	@Override
	public List<String> getCities(Map<String, List<String>> stateCityMap,
			String state) throws InvalidStateException {
		
		List<String> l1 = new ArrayList<String>();
		boolean flag = true;
		for (Map.Entry<String,List<String>> entry : stateCityMap.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(state)){
				l1=entry.getValue();
				flag = false;
				break;
			}
		}
		if(flag)
			throw new InvalidStateException();
		
		
		return l1;
	}

	@Override
	public String getState(Map<String, List<String>> stateCityMap, String city)
			throws CityNotFoundException {
		boolean flag = true;
		String ret = null;
		for (Map.Entry<String, List<String>> map  : stateCityMap.entrySet()) {
			for (String str : map.getValue()) {
				if(str.equalsIgnoreCase(city)){
					ret = map.getKey();
					flag = false;
					break;
				}
				
			}
		}
		if(flag)
			throw new CityNotFoundException();
		return ret;
	}

}
