package com.exercise.sampleone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class AlternatingIteratorTest {
	
	@Test
	public void testCreatingObjectWithEmptyParameterThenObjectExist() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>();
		assertNotNull("Create Object with empty input parameter then object exists", alternatingIterator);
	}
	
	@Test
	public void testCreatingObjectWithNullParameterThenObjectExist() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(null);
		assertNotNull("Create Object with null input parameter then object exists", alternatingIterator);
	}
	
	@Test
	public void testCreatingObjectWithOneParameterAsEmptyListThenObjectExist() {
		List<String> listA = new ArrayList<>();
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter as Empty List then object exists", alternatingIterator);
	}
	
	@Test
	public void testCreatingObjectWithOneParameterHasOneBlankElementInListThenObjectExist() {
		List<String> listA = Arrays.asList("");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter has one blank element in List then object exists", alternatingIterator);
	}
	
	@Test
	public void testCreatingObjectWithOneParameterThenObjectExist() {
		List<String> listA = Arrays.asList("a", "b", "c");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter then object exists", alternatingIterator);
	}
	
	@Test
	public void testOnHasNextMethodWithEmpptyParameterThenGetFalseResult() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>();
		assertNotNull("Create Object with empty input parameter then object exists", alternatingIterator);
		assertTrue("Get false result of hasNext Method when creating Object with empty input parameter", false == alternatingIterator.hasNext());
	}
	
	@Test
	public void testOnHasNextMethodWithNullParameterThenGetFalseResult() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(null);
		assertNotNull("Create Object with null input parameter then object exists", alternatingIterator);
		assertTrue("Get false result of hasNext Method when creating Object with null input parameter", false == alternatingIterator.hasNext());
	}
	
	@Test
	public void testOnHasNextMethodWithOneParameterAsEmptyListThenGetFalseResult() {
		List<String> listA = new ArrayList<>();
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter as Empty List then object exists", alternatingIterator);
		assertTrue("Get false result of hasNext Method when creating Object with one input parameter as Empty List", false == alternatingIterator.hasNext());
	}
	
	@Test
	public void testOnHasNextMethodWithOneParameterHasOneBlankElementInListThenGetFalseResult() {
		List<String> listA = Arrays.asList("");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter has one blank element in List then object exists", alternatingIterator);
		assertTrue("Get false result of hasNext Method when creating Object with one input parameter has one blank element in List", false == alternatingIterator.hasNext());
	}
	
	@Test
	public void testOnHasNextMethodWithOneParameterThenGetTrueResult() {
		List<String> listA = Arrays.asList("a", "b", "c");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter then object exists", alternatingIterator);
		assertTrue("Get true result of hasNext Method when creating Object with one input parameter", true == alternatingIterator.hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOnNextMethodWithEmptyParameterThenGetNoSuchElementExceptionResult() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>();
		assertNotNull("Create Object with empty input parameter then object exists", alternatingIterator);
		alternatingIterator.next();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOnNextMethodWithNullParameterThenGetNoSuchElementExceptionResult() {
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(null);
		assertNotNull("Create Object with null input parameter then object exists", alternatingIterator);
		alternatingIterator.next();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOnNextMethodWithOneParameterAsEmptyListThenGetNoSuchElementExceptionResult() {
		List<String> listA = new ArrayList<>();
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.listIterator());
		assertNotNull("Create Object with Empty List input parameter then object exists", alternatingIterator);
		alternatingIterator.next();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOnNextMethodWithOneParameterHasOneBlankElementInListThenGetNoSuchElementExceptionResult() {
		List<String> listA = Arrays.asList("");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.listIterator());
		assertNotNull("Create Object with one blank element in List input parameter then object exists", alternatingIterator);
		alternatingIterator.next();
	}
	
	@Test
	public void testOnNextMethodWithOneParameterThenGetValidResult() {
		List<String> listA = Arrays.asList("a", "b", "c");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator());
		assertNotNull("Create Object with one input parameter then object exists", alternatingIterator);
		String result = (String) alternatingIterator.next();
		assertNotNull("Should get first element of List is not null", result);
		assertEquals("Should get first element of List is `a`", "a", result);
	}
	
	@Test
	public void testOnNextMethodWithThreeParametersThenGetValidResult() {
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		List<String> listC = Arrays.asList("x", "y", "z");
		AlternatingIterator alternatingIterator = new AlternatingIterator<>(listA.iterator(), listB.iterator(), listC.iterator());
		assertNotNull("Create Object with three parameters then object exists", alternatingIterator);
		String comaSpace = "";
		StringBuilder sb = new StringBuilder();
		while (alternatingIterator.hasNext()) {
			sb.append(comaSpace);
			sb.append(alternatingIterator.next());
			comaSpace = ", ";
		}
		assertEquals("Expected a, 1, x, b, 2, y, c, z", "a, 1, x, b, 2, y, c, z", sb.toString());
	}
}
