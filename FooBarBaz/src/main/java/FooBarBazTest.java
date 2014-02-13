package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooBarBazTest {

	@Test
	public void testFooBarBazInput() throws Exception {
//		fail("Not yet implemented");
		FooBarBaz obb = new FooBarBaz();
		assertEquals("FooBarBaz", obb.fooBarBazInput(001));
	}

}
