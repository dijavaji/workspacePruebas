package ec.com.technoloqie.service.user;

import java.util.List;

import ec.com.technoloqie.model.User;

public interface UserService {
	 	User getUserByUsername(String username);

	    List<String> getPermissions(String username);

	    User getCurrentUser();

	    Boolean isCurrentUserLoggedIn();
}
