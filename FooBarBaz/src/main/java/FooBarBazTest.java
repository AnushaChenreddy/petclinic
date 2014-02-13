package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooBarBazTest {

	@Test
	public void testFooBarBazInput() throws Exception {
		// fail("Not yet implemented");
		FooBarBaz obb = new FooBarBaz();
		assertEquals("BarBaz", obb.fooBarBazInput(35));
	}

	@Test
	public void testReadInput() throws Exception {
		FooBarBaz obb = new FooBarBaz();
//		assertEquals(0, obb.readInput());
		assertEquals(5, obb.readInput());
	}

}
