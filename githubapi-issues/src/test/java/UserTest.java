package test.java;

import main.java.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {

	@Test
	public void testHashCode() {
		User obj1 = new User();
		obj1.setId("abccd");
		User obj2 = new User();
		obj2.setId("abccd");
		User obj3 = new User();
		obj3.setId(null);

		assertEquals(obj1.hashCode(), obj2.hashCode());
		assertEquals(obj1.hashCode(), obj1.hashCode());
		assertTrue(obj1.hashCode() == obj2.hashCode());
		assertFalse(obj3.hashCode() == obj1.hashCode());
	}

	@Test
	public void testEquals() {
		User obj1 = new User();
		obj1.setId("6");
		User obj2 = new User();
		obj2.setId("6");
		User obj3 = new User();
		obj3.setId("abc");
		User obj4 = new User();
		obj4.setId(null);

		assertFalse(obj1.equals(obj3));
		assertTrue(obj1.equals(obj2));
		assertEquals(obj1.equals(obj2), true);
		assertEquals(obj1.equals(obj1), true);
		assertEquals(obj1.equals(obj4), false);
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
