package test.java;

import main.java.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class IssueTest {

	@Test
	public void testHashCode () {
		Issue obj1 = new Issue();
		obj1.setId("abccd");
		Issue obj2 = new Issue();
		obj2.setId("abccdf");
//		User obj3 = new User();
		assertEquals(obj1.hashCode(),obj2.hashCode());
	}

}
