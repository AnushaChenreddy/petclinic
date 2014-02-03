import java.util.*;

public class Issue {

	public Issue() {
		super();
	}

		private long number;
		private String id;
		private String state;
		private String title;
		private String body;
		private Date createdAt;
		private Date closedAt;
		private User user;
		private User assignee;
		/**
		 * @return the number
		 */
		public long getNumber() {
			return number;
		}
		/**
		 * @param number the number to set
		 */
		public void setNumber(long number) {
			this.number = number;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * @return the body
		 */
		public String getBody() {
			return body;
		}
		/**
		 * @param body the body to set
		 */
		public void setBody(String body) {
			this.body = body;
		}
		/**
		 * @return the createdAt
		 */
		public Date getCreatedAt() {
			return createdAt;
		}
		/**
		 * @param createdAt the createdAt to set
		 */
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		/**
		 * @return the closedAt
		 */
		public Date getClosedAt() {
			return closedAt;
		}
		/**
		 * @param closedAt the closedAt to set
		 */
		public void setClosedAt(Date closedAt) {
			this.closedAt = closedAt;
		}
		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}
		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
		}
		/**
		 * @return the assignee
		 */
		public User getAssignee() {
			return assignee;
		}
		/**
		 * @param assignee the assignee to set
		 */
		public void setAssignee(User assignee) {
			this.assignee = assignee;
		}
	

}
