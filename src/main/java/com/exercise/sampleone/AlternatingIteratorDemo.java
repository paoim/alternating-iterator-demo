package com.exercise.sampleone;

import java.util.ArrayList;
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

	private static void displayWithDefaultConstructor() {
		System.out.println("-----------------new AlternatingIterator<>()-----------------");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>();
		printResult(alternatingIterator);
	}

	private static void displayWithNullInput() {
		System.out.println("-----------------new AlternatingIterator<>(null)-----------------");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(null);
		printResult(alternatingIterator);
	}

	private static void displayWithOneEmptyListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA) where listA is Empty-----------------");
		List<String> listA = new ArrayList<>();
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		printResult(alternatingIterator);
	}

	private static void displayWithOneListWithOneEmptyElementInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA) where listA has one empty element-----------------");
		List<String> listA = Arrays.asList("");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		printResult(alternatingIterator);
	}

	private static void displayWithOneValidListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA) where listA is valid-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		// Expected a, b, c
		printResult(alternatingIterator);
	}

	private static void displayWithTwoListHasSecondEmptyListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA, listB) where listB is empty-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = new ArrayList<>();
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator());
		// Expected a, b, c
		printResult(alternatingIterator);
	}

	private static void displayWithTwoListHasSecondListHasOneEmptyElementInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA, listB) where listB has empty-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator());
		// Expected a, b, c
		printResult(alternatingIterator);
	}

	private static void displayWithTwoListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA, listB)-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator());
		// Expected a, 1, b, 2, c
		printResult(alternatingIterator);
	}

	private static void displayWithThreeListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA, listB, listC)-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		List<String> listC = Arrays.asList("x", "y", "z");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator(), listC.iterator());
		// Expected a, 1, x, b, 2, y, c, z
		printResult(alternatingIterator);
	}

	private static void displayWithFourListInput() {
		System.out.println("-----------------new AlternatingIterator<>(listA, listB, listC, listD)-----------------");
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		List<String> listC = Arrays.asList("x", "y", "z");
		List<String> listD = Arrays.asList("A", "B", "C", "D");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator(), listC.iterator(), listD.iterator());
		// Expected a, 1, x, A, b, 2, y, B, c, z, C, D
		printResult(alternatingIterator);
	}

	public static void main(String[] args) {
		displayWithDefaultConstructor();
		displayWithNullInput();
		displayWithOneEmptyListInput();
		displayWithOneListWithOneEmptyElementInput();
		displayWithOneValidListInput();
		displayWithTwoListHasSecondEmptyListInput();
		displayWithTwoListHasSecondListHasOneEmptyElementInput();
		displayWithTwoListInput();
		displayWithThreeListInput();
		displayWithFourListInput();
	}
}
