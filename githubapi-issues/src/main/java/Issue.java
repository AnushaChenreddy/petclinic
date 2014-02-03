/**
 * @author Anusha
 *
 */
import java.util.*;

public class Issue {

		private long number;
		private String id;
		private boolean state;
		private String title;
		private String body;
		private Date createdAt;
		private Date closedAt;
		private User user;
		private User assignee;
		
		public Issue() {
		}

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
		public boolean isState() {
			return state;
		}

		/**
		 * @param state the state to set
		 */
		public void setState(boolean state) {
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

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((assignee == null) ? 0 : assignee.hashCode());
			result = prime * result + ((body == null) ? 0 : body.hashCode());
			result = prime * result
					+ ((closedAt == null) ? 0 : closedAt.hashCode());
			result = prime * result
					+ ((createdAt == null) ? 0 : createdAt.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + (int) (number ^ (number >>> 32));
			result = prime * result + (state ? 1231 : 1237);
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Issue other = (Issue) obj;
			if (assignee == null) {
				if (other.assignee != null)
					return false;
			} else if (!assignee.equals(other.assignee))
				return false;
			if (body == null) {
				if (other.body != null)
					return false;
			} else if (!body.equals(other.body))
				return false;
			if (closedAt == null) {
				if (other.closedAt != null)
					return false;
			} else if (!closedAt.equals(other.closedAt))
				return false;
			if (createdAt == null) {
				if (other.createdAt != null)
					return false;
			} else if (!createdAt.equals(other.createdAt))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (number != other.number)
				return false;
			if (state != other.state)
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

}
