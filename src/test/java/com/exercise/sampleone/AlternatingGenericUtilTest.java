package com.exercise.sampleone;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AlternatingGenericUtilTest {
	
	@Test
	public void testGettingValuesWithoutInputParameterThenGetNullResult() {
		Object object[] = AlternatingGenericUtil.getValues();
		assertNull("Get null value when does not input any parameter as varargs", object);
	}
	
	@Test
	public void testGettingValuesWithInputNullParameterThenGetNullResult() {
		Object object[] = AlternatingGenericUtil.getValues(null);
		assertNull("Get null value when input null parameter as varargs", object);
	}
	
	@Test
	public void testGettingValuesWithInputOneParameterAsEmptyListThenGetEmptyArrayOfObject() {
		List<String> list = new ArrayList<>();
		Object object[] = AlternatingGenericUtil.getValues(list.iterator());
		assertTrue("Get Empty Array of Objects when input one parameter as varargs (empty list)", object.length == 0);
	}
	
	@Test
	public void testGettingValuesWithInputOneParameterAsEmptyElementThenGetEmptyArrayOfObject() {
		List<String> list = Arrays.asList("");
		Object object[] = AlternatingGenericUtil.getValues(list.iterator());
		assertTrue("Get Empty Array of Objects when input one parameter as varargs (List has one element as blank)", object.length == 0);
	}
	
	@Test
	public void testGettingValuesWithInputOneParameterThenGetArrayOfObjects() {
		List<String> list = Arrays.asList("a", "b", "c");
		Object object[] = AlternatingGenericUtil.getValues(list.iterator());
		assertTrue("Get Array of Objects when input one parameter as varargs", object.length > 0);
	}
	
	@Test
	public void testGettingValuesWithInputTwoParametersWhenSecondListIsEmptyThenGetArrayOfObjects() {
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = new ArrayList<>();
		Object object[] = AlternatingGenericUtil.getValues(listA.iterator(), listB.iterator());
		assertTrue("Get Array of Objects when input two parameters as varargs (Second List is empty)", object.length > 0);
	}
	
	@Test
	public void testGettingValuesWithInputTwoParametersWhenSecondListHasOneEmptyElementThenGetArrayOfObjects() {
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("");
		Object object[] = AlternatingGenericUtil.getValues(listA.iterator(), listB.iterator());
		assertTrue("Get Array of Objects when input two parameters as varargs (Second List has one blank element)", object.length > 0);
	}
	
	@Test
	public void testGettingValuesWithInputTwoParametersThenGetArrayOfObjects() {
		List<String> listA = Arrays.asList("a", "b", "c");
		List<String> listB = Arrays.asList("1", "2");
		Object object[] = AlternatingGenericUtil.getValues(listA.iterator(), listB.iterator());
		assertTrue("Get Array of Objects when input two parameters as varargs", object.length > 0);
	}
}
