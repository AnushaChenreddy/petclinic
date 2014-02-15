package test.java;

import main.java.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testHashCode() {
		User obj1 = new User();
		obj1.setId("abccd");
		User obj2 = new User();
		obj2.setId("abccd");

		assertEquals(obj1.hashCode(), obj2.hashCode());
		assertEquals(obj1.hashCode(), obj1.hashCode());
		assertTrue(obj1.hashCode() == obj2.hashCode());
	}

	@Test
	public void testEquals() {
		User obj1 = new User();
		obj1.setId("6");
		User obj2 = new User();
		obj2.setId("6");
		User obj3 = new User();
		obj3.setId("abc");

		assertFalse(obj1.equals(obj3));
		assertTrue(obj1.equals(obj2));
		assertEquals(obj1.equals(obj2), true);
		assertEquals(obj1.equals(obj1), true);
	}

	@Test
	/* Checking by passing a correct string */
	public void testToString() {
		User user_obj = new User();
		String tester = "User [login=user1, " + "id=userid01]";
		user_obj.setId("userid01");
		user_obj.setLogin("user1");

		assertEquals(tester, user_obj.toString());

		/* Passing a string with improper order */
		User user_obj1 = new User();
		String test = "User=User [id=userid02, login=user2]";
		user_obj1.setId("userid02");
		user_obj1.setLogin("user2");

		assertFalse(test == user_obj1.toString());

	}

}
