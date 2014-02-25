package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.java.Issue;
import main.java.User;

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
		Issue issueObj = new Issue();
		User userObj = new User();
		User assigneeObj = new User();
		String tester = "Issue [number=1, " + "id=iss01, " + "state=true, "
				+ "title=Title of Issue, " + "body=Body of Issue, "
				+ "createdAt=null, " + "closedAt=null, "
				+ "user=User [login=user1, id=userid01], "
				+ "assignee=User [login=assignee1, id=userid01]]";
		issueObj.setId("iss01");
		issueObj.setNumber(1);
		issueObj.setState(true);
		issueObj.setTitle("Title of Issue");
		issueObj.setBody("Body of Issue");
		userObj.setId("userid01");
		userObj.setLogin("user1");
		assigneeObj.setId("userid01");
		assigneeObj.setLogin("assignee1");
		issueObj.setAssignee(assigneeObj);
		issueObj.setUser(userObj);

		assertEquals(tester, issueObj.toString());

		/* Passing a string with improper order */
		Issue issueObj1 = new Issue();
		User userObj1 = new User();
		User assigneeObj1 = new User();
		String test = "Issue [id=iss02, " + "number=2, " + "state=true, "
				+ "title=null, " + "body=null, " + "createdAt=null, "
				+ "closedAt=null, " + "user=User [id=userid02, login=user2], "
				+ "assignee=User [id=userid02, login=assignee2]]";
		issueObj1.setId("iss02");
		issueObj1.setNumber(2);
		issueObj1.setState(true);
		userObj1.setId("userid02");
		userObj1.setLogin("user2");
		assigneeObj1.setId("userid02");
		assigneeObj1.setLogin("assignee2");
		issueObj1.setAssignee(assigneeObj1);
		issueObj1.setUser(userObj1);

		assertFalse(test == issueObj1.toString());

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
		assertEquals(-1, obj4.compareTo(obj2)); // 4 vs 5
		assertEquals(0, obj3.compareTo(obj2)); // 5 vs 5
		assertNotEquals(-5, obj4.compareTo(obj2)); // checking for a -ve num
		assertNotEquals(10, obj1.compareTo(obj2)); // checking for a +ve num

	}

}
