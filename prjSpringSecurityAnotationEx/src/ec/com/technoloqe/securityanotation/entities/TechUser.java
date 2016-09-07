package ec.com.technoloqe.securityanotation.entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class TechUser implements Serializable{
	
	 	private Integer id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private String role;
	    private boolean enabled;
	    
	    /**
	     * Gets the email address for this user. When authenticating against this data directly, this is also used as the
	     * username.
	     *
	     * @return
	     */
	    public String getEmail() {
	        return email;
	    }

	    /**
	     * Gets the first name of the user.
	     *
	     * @return
	     */
	    public String getFirstName() {
	        return firstName;
	    }

	    /**
	     * Gets the id for this user. When creating a new user this should be null, otherwise it will be non-null.
	     *
	     * @return
	     */
	    public Integer getId() {
	        return id;
	    }

	    /**
	     * Gets the last name of the user.
	     *
	     * @return
	     */
	    public String getLastName() {
	        return lastName;
	    }

	    /**
	     * Gets the password for this user. In some instances, this password is not actually used. For example, when an in
	     * memory authentication is used the password on the spring security User object is used.
	     *
	     * @return
	     */
	    @JsonIgnore
	    public String getPassword() {
	        return password;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // --- convenience methods ---

	    /**
	     * Gets the full name in a formatted fashion. Note in a real application a formatter may be more appropriate, but in
	     * this application simplicity is more important.
	     *
	     * @return
	     */
	    @JsonIgnore
	    public String getName() {
	        return getLastName() + ", " + getFirstName();
	    }

	    // --- override Object ---

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        TechUser other = (TechUser) obj;
	        if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        return true;
	    }

	    private static final long serialVersionUID = 8433999509932007961L;

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
}
