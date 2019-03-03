package com.hoolah.transactionanalyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Below program is used to convert the string to Sum of ASCII value and Sort
 * the o/p in Descending order
 * 
 * @author Ramesh
 *
 */
public class AsciiValueOfSimprint {

	private static final Map<Integer, String> asciiMap = new HashMap<Integer, String>();

	/**
	 * Method to convert the String to ASCII
	 * 
	 * @param value
	 */
	public static void convertStringToAscii(String value) {

		int len = value.length();
		int totalAscii = 0;
		for (int i = 0; i < len; i++) {

			int asciChar = value.charAt(i);
			totalAscii = totalAscii + asciChar;
		}
		asciiMap.put(totalAscii, value);

	}

	/**
	 * Method to Scort and Print the converted ASCII value and Passed String
	 * 
	 * @param inputList
	 */
	public static void printAsciiOrder(List<String> inputList) {

		for (String inputVal : inputList) {
			AsciiValueOfSimprint.convertStringToAscii(inputVal);
		}

		List<Entry<Integer, String>> sortedEntries = new ArrayList<Entry<Integer, String>>(asciiMap.entrySet());
		Collections.sort(sortedEntries, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> a, Entry<Integer, String> b) {
				return b.getKey().compareTo(a.getKey());
			}
		});

		for (Object object : sortedEntries) {
			System.out.println((Map.Entry) object);
		}

	}

	public static void main(String arg[]) {
		List<String> inputList = new ArrayList<String>();
		inputList.add("Robust as Fudge");
		inputList.add("Be Surprisingly Bold");
		inputList.add("Get Back Up");
		inputList.add("Make It Happen");
		inputList.add("Don't Be a Jerk");
		inputList.add("Relentless Commitment to Impact");
		inputList.add("Confront the Grey");
		inputList.add("Laugh Together, Grow Together");
		// inputList.add("Simprints, every person counts");
		AsciiValueOfSimprint.printAsciiOrder(inputList);

	}

}
