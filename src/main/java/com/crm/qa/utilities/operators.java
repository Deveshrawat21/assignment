package com.crm.qa.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebElement;

import flight.Flight;

public class operators {

	public static Set<Entry<String, String>> sortPriceValue(List<WebElement> flightName, List<WebElement> flightPrice) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < flightName.size(); i++) {
			String price = flightPrice.get(i).getText().replaceAll("[\\u20B9]", "").replaceAll("per traveller", "")
					.trim();
			hashMap.put(flightName.get(i).getText(), price);
		}

		List<Map.Entry<String, String>> entries = new ArrayList(hashMap.entrySet());
		entries.sort(Map.Entry.comparingByValue());

		LinkedHashMap<String, String> sortedHashMap = new LinkedHashMap<>();
		for (Map.Entry<String, String> entry : entries) {
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap.entrySet();
	}
	

}
