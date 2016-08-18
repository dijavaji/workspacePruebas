package ec.com.technoloqie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.com.technoloqie.model.User;
import ec.com.technoloqie.security.TechUserDetails;
import ec.com.technoloqie.service.user.UserService;

@Service
public class TechUserDetailsService implements UserDetailsService{
	
	@Autowired(required=true)
	private UserService userService;
	
	@Autowired(required=true)
	public TechUserDetailsService(UserService userService) {
        this.userService = userService;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
        List<String> permissions = userService.getPermissions(user.getLogin());
        for (String permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
        }

        return new TechUserDetails(user, grantedAuthorities);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
