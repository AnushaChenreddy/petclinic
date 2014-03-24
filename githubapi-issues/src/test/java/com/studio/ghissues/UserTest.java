package com.studio.ghissues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.studio.ghissues.User;

public class UserTest {

	@Test
	public void testHashCode() {
		User userObj1 = new User();
		userObj1.setId("abccd");
		User userObj2 = new User();
		userObj2.setId("abccd");
		User userObj3 = new User();
		userObj3.setId(null);

		assertEquals(userObj1.hashCode(), userObj2.hashCode());
		assertEquals(userObj1.hashCode(), userObj1.hashCode());
		assertTrue(userObj1.hashCode() == userObj2.hashCode());
		assertFalse(userObj3.hashCode() == userObj1.hashCode());
	}

	@Test
	public void testEquals() {
		User userObj1 = new User();
		userObj1.setId("6");
		User userObj2 = new User();
		userObj2.setId("6");
		User userObj3 = new User();
		userObj3.setId("abc");
		User userObj4 = new User();
		userObj4.setId(null);

		assertFalse(userObj1.equals(userObj3));
		assertTrue(userObj1.equals(userObj2));
		assertEquals(true, userObj1.equals(userObj2));
		assertEquals(true, userObj1.equals(userObj1));
		assertEquals(false, userObj1.equals(userObj4));
	}

	@Test
	/* Checking by passing a correct string */
	public void testToString() {
		User userobj = new User();
		String tester = "User [login=user1, " + "id=userid01]";
		userobj.setId("userid01");
		userobj.setLogin("user1");

		assertEquals(tester, userobj.toString());

		/* Passing a string with improper order */
		User userobj1 = new User();
		String test = "User=User [id=userid02, login=user2]";
		userobj1.setId("userid02");
		userobj1.setLogin("user2");

		assertFalse(test == userobj1.toString());

	}

}
