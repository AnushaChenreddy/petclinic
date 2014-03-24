package com.studio.ghissues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.studio.ghissues.Issue;
import com.studio.ghissues.User;

public class IssueTest {

	@Test
	public void testHashCode() {
		Issue issueObj1 = new Issue();
		issueObj1.setId("abccd");
		Issue issueObj2 = new Issue();
		issueObj2.setId("abccd");
		Issue issueObj3 = new Issue();
		issueObj3.setId(null);

		assertEquals(issueObj1.hashCode(), issueObj2.hashCode());
		assertEquals(issueObj1.hashCode(), issueObj1.hashCode());
		assertTrue(issueObj1.hashCode() == issueObj2.hashCode());
		assertFalse(issueObj3.hashCode() == issueObj1.hashCode());
	}

	@Test
	public void testEquals() {
		Issue issueObj1 = new Issue();
		issueObj1.setId("6");
		Issue issueObj2 = new Issue();
		issueObj2.setId("6");
		Issue issueObj3 = new Issue();
		issueObj3.setId("abc");
		Issue issueObj4 = new Issue();
		issueObj4.setId(null);
		User userObj = new User();
		userObj.setId("userid01");

		assertFalse(issueObj1.equals(issueObj3));
		assertTrue(issueObj1.equals(issueObj2));
		assertEquals(true, issueObj1.equals(issueObj2));
		assertEquals(true, issueObj1.equals(issueObj1));
		assertEquals(false, issueObj4.equals(null));
		assertEquals(false, issueObj4.equals(userObj));
		assertEquals(false, issueObj4.equals("Hello"));
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
		issueObj.setState("true");
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
		issueObj1.setState("true");
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
		Issue issueObj1 = new Issue();
		Issue issueObj2 = new Issue();
		Issue issueObj3 = new Issue();
		Issue issueObj4 = new Issue();
		Issue issueObj5 = new Issue();
		issueObj1.setId("6");
		issueObj2.setId("5");
		issueObj3.setId("5");
		issueObj4.setId("4");
		issueObj5.setId(" ");
		assertEquals(1, issueObj1.compareTo(issueObj2));
		assertEquals(-1, issueObj4.compareTo(issueObj2));
		assertEquals(0, issueObj3.compareTo(issueObj2));
		assertNotEquals(-5, issueObj4.compareTo(issueObj2));
		assertNotEquals(10, issueObj1.compareTo(issueObj2));

	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerExceptionForCompareTo() {
		Issue issueObj = new Issue();
		issueObj.setId("5");
		issueObj.compareTo(null);
	}

}
