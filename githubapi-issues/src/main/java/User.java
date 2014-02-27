package main.java;

/**
 * @author Anusha Chenreddy
 * @created_on 03-Feb-2014
 */
public class User {

	private String login;
	private String id;

	/* public no-argument constructor */
	public User() {

	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* toString() method to represent the object’s attributes. */
	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + "]";
	}

}
