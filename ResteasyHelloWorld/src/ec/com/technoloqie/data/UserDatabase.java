package ec.com.technoloqie.data;

import java.util.Date;
import java.util.HashMap;

import ec.com.technoloqie.entity.User;

public class UserDatabase {
	
	 public static HashMap<Integer, User> users = new HashMap<Integer, User>();
	    static
	    {
	        User user = new User();
	        user.setId(1);
	        user.setFirstName("cris");
	        user.setLastName("rosero");
	        user.setUri("/user-management/users/1");
	        user.setLastModified(new Date());
	        User user1 = new User();
	        user1.setId(2);
	        user1.setFirstName("sofia");
	        user1.setLastName("arichal");
	        user1.setUri("/user-management/users/2");
	        user1.setLastModified(new Date());
	        users.put(2, user1);
	    }
	     
	    public static User getUserById(Integer id)
	    {
	        return users.get(id);
	    }
	     
	    public static void updateUser(Integer id)
	    {
	        User user = users.get(id);
	        user.setLastModified(new Date());
	    }
	     
	    public static Date getLastModifiedById(Integer id)
	    {
	        return users.get(id).getLastModified();
	    }
}
