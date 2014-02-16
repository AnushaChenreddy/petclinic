package test.java;

import static org.junit.Assert.*;

import java.util.List;

import main.java.*;

import org.junit.Test;

import java.io.*;

public class IssueParserTest {
	String sampleOutput;

	@Test
	public void test() throws Exception {
		setUp();
		IssueParser obj = new IssueParser();
		List<Issue> issues = obj.parseIssues(sampleOutput);
		assertNotNull(issues);
		assertEquals(3, issues.size());

		Issue issue0 = issues.get(0);
		assertEquals("Changing the name of the class file", issue0.getTitle());
		assertEquals(
				"I have created a java class with the name 'FooBarBuz' and I wanted to rename it to 'FooBarBaz'.",
				issue0.getBody());
		assertEquals("AnushaChenreddy", issue0.getUser().getLogin());
		assertEquals("AnushaChenreddy", issue0.getAssignee().getLogin());
		assertEquals(3, issue0.getNumber());
		assertEquals(false, issue0.isState());
		assertEquals(null, issue0.getClosedAt());

		Issue issue1 = issues.get(1);
		assertEquals(
				"Handling files in an OS-independent, user-independent way.",
				issue1.getTitle());
		assertEquals(
				"For saving the output of a java file to a text file, "
						+ "If we give a path that is local to our environment it works well when we execute it on our PC. "
						+ "But it we want to run the program from a different environment we will have to change the path given"
						+ " in the program. How to handle them in an OS-independent, user-independent way.",
				issue1.getBody());
		assertEquals("AnushaChenreddy", issue1.getUser().getLogin());
		assertEquals("AnushaChenreddy", issue1.getAssignee().getLogin());
		assertEquals(2, issue1.getNumber());
		assertEquals(false, issue1.isState());
		assertEquals(null, issue1.getClosedAt());

		Issue issue2 = issues.get(2);
		assertEquals("Child1", issue2.getTitle());
		assertEquals("Submitting pull request!", issue2.getBody());
		assertEquals("AnushaChenreddy", issue2.getUser().getLogin());
		assertEquals("AnushaChenreddy", issue2.getAssignee().getLogin());
		assertEquals(1, issue2.getNumber());
		assertEquals(false, issue2.isState());
		assertEquals(null, issue2.getClosedAt());
	}

//	@Override
	public void setUp() throws Exception {
		BufferedReader reader = null;
		FileReader inputFile = null;
		try {
			String path = System.getProperty("user.dir");
			inputFile = new FileReader(path
					+ "/src/test/java/SampleOutput.json");
			reader = new BufferedReader(inputFile);
			StringBuffer fileContent = new StringBuffer(reader.readLine());
			while (reader.ready()) {
				fileContent.append(reader.readLine());
			}
			sampleOutput = fileContent.toString();
			System.out.println(sampleOutput);
		} catch (Exception e) {
			System.out.println("Error Message" + e.getMessage());
		} finally {
			reader.close();
			inputFile.close();
		}

	}

}
