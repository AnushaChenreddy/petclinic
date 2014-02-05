/* @author Anusha Chenreddy
 * @created_on 03-Feb-2014
 */
import java.io.*;
import java.util.*;

public class IssuesExporter {

	public static void main(String[] args) throws Exception {
		IssuesExporter obj = new IssuesExporter();
		ArrayList<Issue> myList = new ArrayList<Issue>();
		obj.readInput();
		obj.issueList(myList);
		obj.numberOfIssues(myList);
		obj.writeToFile(myList);
	}

	/* Method to read input from console */
	public void readInput() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter your GitHub username:");
			String username = input.nextLine();
			System.out.println("Enter your password:");
			String password = input.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid Input");
		} finally {
			input.close();
		}
	}

	/* This method adds issues to the collection */
	public void issueList(ArrayList<Issue> myList) {
		User user1 = populateUser("anusha", "userid01");
		User assignee1 = populateUser("anusha", "userid01");
		Issue issue1 = populateIssue(Long.valueOf(001), "iss01", true,
				"Title of Issue1", "Body of Issue1", new Date(2014 - 02 - 03),
				new Date(), user1, assignee1);

		User user2 = populateUser("user2", "userid02");
		User assignee2 = populateUser("assignee2", "userid01");
		Issue issue2 = populateIssue(Long.valueOf(002), "iss02", true,
				"Title of Issue2", "Body of Issue2", new Date(2014 - 02 - 03),
				new Date(), user2, assignee2);

		User user3 = populateUser("user3", "userid03");
		User assignee3 = populateUser("assignee3", "userid01");
		Issue issue3 = populateIssue(Long.valueOf(003), "iss03", false,
				"Title of Issue3", "Body of Issue3", new Date(2014 - 02 - 03),
				new Date(), user3, assignee3);

		myList.add(issue1);
		myList.add(issue2);
		myList.add(issue3);
	}

	/* This method populates issues */
	public Issue populateIssue(long number, String id, boolean state,
			String title, String body, Date createdAt, Date closedAt,
			User user, User assignee) {
		Issue issue = new Issue();
		issue.setId(id);
		issue.setNumber(number);
		issue.setState(state);
		issue.setTitle(title);
		issue.setBody(body);
		issue.setCreatedAt(createdAt);
		if (state != false) {
			issue.setClosedAt(null);
		} else {
			issue.setClosedAt(closedAt);
		}
		issue.setUser(user);
		issue.setAssignee(assignee);
		return issue;
	}

	/* this method populates users */
	public User populateUser(String userName, String id) {
		User user = new User();
		user.setLogin(userName);
		user.setId(id);
		return user;
	}

	/* Method to calculate the size of collection or number of issues */
	public void numberOfIssues(ArrayList<Issue> myList) {
		int size = myList.size();
		System.out.println("Number of Issues:" + size);
	}

	/*
	 * Method to write to issues.txt file. This method invokes the toString()
	 * method of Issue class
	 */
	public void writeToFile(ArrayList<Issue> myList) throws Exception {

		FileWriter fw = new FileWriter("issues.txt", false);
		try {
			String newline = System.getProperty("line.separator");
			Iterator<Issue> iterate = myList.iterator();
			while (iterate.hasNext()) {
				Issue issue = iterate.next();
				String text = issue.toString();
				System.out.println(text);
				fw.write(text + newline);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fw.close();
		}
	}
}