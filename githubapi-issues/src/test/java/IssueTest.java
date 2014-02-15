package test.java;

import main.java.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class IssueTest {

	@Test
	public void testHashCode() {
		Issue obj1 = new Issue();
		obj1.setId("abccd");
		Issue obj2 = new Issue();
		obj2.setId("abccd");
		assertEquals(obj1.hashCode(), obj2.hashCode());
		assertEquals(obj1.hashCode(), obj1.hashCode());
		assertTrue(obj1.hashCode() == obj2.hashCode());
	}

	@Test
	public void testEquals() {
		Issue obj1 = new Issue();
		obj1.setId("6");
		Issue obj2 = new Issue();
		obj2.setId("6");
		Issue obj3 = new Issue();
		obj3.setId("abc");
		assertFalse(obj1.equals(obj3));
		assertTrue(obj1.equals(obj2));
		assertEquals(obj1.equals(obj2), true);
		assertEquals(obj1.equals(obj1), true);
	}

}
