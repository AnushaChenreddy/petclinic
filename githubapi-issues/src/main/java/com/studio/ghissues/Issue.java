package com.studio.ghissues;

import java.util.Date;

/**
 * @author Anusha
 */

public class Issue implements Comparable<Object> {

	private long number;
	private String id;
	private String state;
	private String title;
	private String body;
	private Date createdAt;
	private Date closedAt;
	private User user;
	private User assignee;

	/* public no-argument constructor */
	public Issue() {
	}

	/**
	 * @return the number
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
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
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id
	 *            the id to set
	 */

	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
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
	 * @param title
	 *            the title to set
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
	 * @param body
	 *            the body to set
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
	 * @param createdAt
	 *            the createdAt to set
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
	 * @param closedAt
	 *            the closedAt to set
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
	 * @param user
	 *            the user to set
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
	 * @param assignee
	 *            the assignee to set
	 */
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	/* Hash on the internal id. */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (id != null) {
			result = prime * result + id.hashCode();
		}
		return result;
	}

	/*
	 * equals() method - defining equality as two issues having the same
	 * internal id.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Issue other = (Issue) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/*
	 * toString() method to represent the object’s attributes. Issue.toString()
	 * // * invoking User.toString() to represent the user and assignee. //
	 */
	@Override
	public String toString() {
		return "Issue [number=" + number + ", id=" + id + ", state=" + state
				+ ", title=" + title + ", body=" + body + ", createdAt="
				+ createdAt + ", closedAt=" + closedAt + ", user="
				+ user.toString() + ", assignee=" + assignee.toString() + "]";
	}

	public int compareTo(Object obj) {
		if (getClass() != obj.getClass()) {
			return -1;
		}
		Issue other = (Issue) obj;
		int locIntVal = Integer.parseInt(id);
		int objIntVal = Integer.parseInt(other.id);
		if (obj != null) {
			if (locIntVal == objIntVal) {
				return 0;
			} else if (locIntVal > objIntVal) {
				return 1;
			} else {
				return -1;
			}
		}
		return -1;

	}

}
