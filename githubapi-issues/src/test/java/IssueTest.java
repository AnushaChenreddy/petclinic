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
		Issue obj3 = new Issue();
		obj3.setId(null);

		assertEquals(obj1.hashCode(), obj2.hashCode());
		assertEquals(obj1.hashCode(), obj1.hashCode());
		assertTrue(obj1.hashCode() == obj2.hashCode());
		assertFalse(obj3.hashCode() == obj1.hashCode());
	}

	@Test
	public void testEquals() {
		Issue obj1 = new Issue();
		obj1.setId("6");
		Issue obj2 = new Issue();
		obj2.setId("6");
		Issue obj3 = new Issue();
		obj3.setId("abc");
		Issue obj4 = new Issue();
		obj4.setId(null);

		assertFalse(obj1.equals(obj3));
		assertTrue(obj1.equals(obj2));
		assertEquals(obj1.equals(obj2), true);
		assertEquals(obj1.equals(obj1), true);
		assertEquals(obj4.equals(null), false);
	}

	@Test
	/* Checking by passing a correct string */
	public void testToString() {
		Issue iss_obj = new Issue();
		User user_obj = new User();
		User assignee_obj = new User();
		String tester = "Issue [number=1, " + "id=iss01, " + "state=true, "
				+ "title=Title of Issue, " + "body=Body of Issue, "
				+ "createdAt=null, " + "closedAt=null, "
				+ "user=User [login=user1, id=userid01], "
				+ "assignee=User [login=assignee1, id=userid01]]";
		iss_obj.setId("iss01");
		iss_obj.setNumber(1);
		iss_obj.setState(true);
		iss_obj.setTitle("Title of Issue");
		iss_obj.setBody("Body of Issue");
		user_obj.setId("userid01");
		user_obj.setLogin("user1");
		assignee_obj.setId("userid01");
		assignee_obj.setLogin("assignee1");
		iss_obj.setAssignee(assignee_obj);
		iss_obj.setUser(user_obj);

		assertEquals(tester, iss_obj.toString());

		/* Passing a string with improper order */
		Issue iss_obj1 = new Issue();
		User user_obj1 = new User();
		User assignee_obj1 = new User();
		String test = "Issue [id=iss02, " + "number=2, " + "state=true, "
				+ "title=null, " + "body=null, " + "createdAt=null, "
				+ "closedAt=null, " + "user=User [id=userid02, login=user2], "
				+ "assignee=User [id=userid02, login=assignee2]]";
		iss_obj1.setId("iss02");
		iss_obj1.setNumber(2);
		iss_obj1.setState(true);
		user_obj1.setId("userid02");
		user_obj1.setLogin("user2");
		assignee_obj1.setId("userid02");
		assignee_obj1.setLogin("assignee2");
		iss_obj1.setAssignee(assignee_obj1);
		iss_obj1.setUser(user_obj1);

		assertFalse(test == iss_obj1.toString());

	}

	@Test
	public void testCompareTo() {
		Issue obj1 = new Issue();
		Issue obj2 = new Issue();
		Issue obj3 = new Issue();
		Issue obj4 = new Issue();
		obj1.setId("6");
		obj2.setId("5");
		obj3.setId("5");
		obj4.setId("4");
		assertEquals(1, obj1.compareTo(obj2)); // 6 vs 5
		assertEquals(-1, obj4.compareTo(obj2));// 4 vs 5
		assertEquals(0, obj3.compareTo(obj2)); // 5 vs 5
		assertEquals(-5, obj4.compareTo(obj2));// checking for a -ve num
		assertEquals(10, obj1.compareTo(obj2));// checking for a +ve num

	}

}
