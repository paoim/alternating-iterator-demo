package com.exercise.sampleone;

import java.util.Arrays;
import java.util.List;

public class AlternatingIteratorDemo {

	private static void printResult(AlternatingIterator alternatingIterator) {
		if (null == alternatingIterator) {
			return;
		}
		String comaSpace = "";
		StringBuilder sb = new StringBuilder();
		while (alternatingIterator.hasNext()) {
			sb.append(comaSpace);
			sb.append(alternatingIterator.next());
			comaSpace = ", ";
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		List<String> listC = Arrays.asList("x", "y", "z");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator(), listC.iterator());
		// Expected a, 1, x, b, 2, y, c, z
		printResult(alternatingIterator);
	}
}
