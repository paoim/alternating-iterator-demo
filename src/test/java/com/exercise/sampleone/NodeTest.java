package com.exercise.sampleone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class NodeTest {
	
	@Test
	public void canConstructANodeWithNull() {
		Node node = new Node<>(null);
		assertNotNull("Create Node Object with null then will get node Object with null data", node);
		assertNull("Get null data when create object with null", node.getData());
		assertNull("Get null Next Node when create object with null", node.getNext());
	}
	
	@Test
	public void canConstructANodeWithStringData() {
		String data = "My Node";
		Node node = new Node<>(data);
		assertNotNull("Create Node Object with valid data", node);
		assertEquals(data, node.getData());
		assertNull("Get null Next Node when create object with valid data", node.getNext());
	}
}
