/**
 * @author Anusha Chenreddy
 * @created_on 03-Feb-2014
 */
public class User {

		private String login;
		private String id;
		
		public User() {

		}

		/**
		 * @return the login
		 */
		public String getLogin() {
			return login;
		}

		/**
		 * @param login the login to set
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
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			
			User other = (User) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "User [login=" + login + ", id=" + id + "]";
		}

}
