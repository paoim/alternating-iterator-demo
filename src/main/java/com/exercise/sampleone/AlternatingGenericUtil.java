package com.exercise.sampleone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlternatingGenericUtil {

	/**
	 * Helper Method to valid data, not blank or empty string
	 * 
	 * @param data
	 * @return true/false
	 */
	private static boolean isValidData(Object data) {
		if (null != data) {
			String str = data.toString();
			return (null != str && !str.isEmpty());
		}
		return false;
	}
	
	/**
	 * Helper Method to convert from List to Array
	 * 
	 * @param list
	 * @return Array of E where E is the generic object
	 */
	private static <E> E[] convertListToArray(List<E> list) {
		E array[] = (E[]) list.stream().filter(item -> isValidData(item)).toArray();
		return array;
	}
	
	/**
	 * Helper Method to convert from Iterator to List
	 * 
	 * @param iterator
	 * @return List of E where E is the generic object
	 */
	private static <E> List<E> convertIteratorToList(Iterator<E> iterator) {
		List<E> list = new ArrayList<>();
		iterator.forEachRemaining(list::add);
		return list;
	}
	
	/**
	 * Helper Method to convert from Iterator to Array
	 * 
	 * @param iterator
	 * @return Array of E where E is the generic object
	 */
	private static <E> E[] convertIteratorToArray(Iterator<E> iterator) {
		List<E> list = convertIteratorToList(iterator);
		E array[] = convertListToArray(list);
		return array;
	}
	
	/**
	 * Helper Method to produce the elements in order
	 * if input like this:
	 * [a,b,c], [1,2], and [x,y,z]
	 * Then it will display:
	 * 'a, 1, x, b, 2, y, c, z'
	 * 
	 * @param iterators
	 * @return Array of E where E is the generic object
	 */
	public static <E> E[] getValues(Iterator<E>... iterators) {
		if (null == iterators || 0 == iterators.length) {
			return null;
		}
		if (1 < iterators.length) {
			// Multiple Arrays - need to display in order
			List<E[]> arrayList = new ArrayList<>();
			int maxInnerArraySize = Integer.MIN_VALUE;
			
			// Loop all iterators
			for (Iterator<E> iterator : iterators) {
				E[] innerArray = convertIteratorToArray(iterator);
				if (maxInnerArraySize < innerArray.length) {
					maxInnerArraySize = innerArray.length;
				}
				arrayList.add(innerArray);
			}
			
			// Merge all Arrays into one Array with the pattern of array1[0], array2[0], array3[0]..., array1[1], array2[1], array3[1],..., array1[2], array2[2], array3[2]...
			List<E> mergeList = new ArrayList<>();
			E outerArray[] = (E[]) arrayList.toArray();
			for (int i = 0; i < maxInnerArraySize; i++) {
				for (int j = 0; j < outerArray.length; j++) {
					E innerArray[] = (E[]) outerArray[j];
					try {
						mergeList.add(innerArray[i]);
					} catch (ArrayIndexOutOfBoundsException e) {
						// Ignore if Exception Occurs
					}
				}
			}
			E values[] = convertListToArray(mergeList);
			return values;
		} else {
			// Single Array - still display as it is, just convert from Iterator to Array
			E values[] = convertIteratorToArray(iterators[0]);
			return values;
		}
	}
}
