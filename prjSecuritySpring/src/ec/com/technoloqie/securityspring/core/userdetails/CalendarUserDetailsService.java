package ec.com.technoloqie.securityspring.core.userdetails;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ec.com.technoloqie.securityspring.core.authority.CalendarUserAuthorityUtils;
import ec.com.technoloqie.securityspring.dataaccess.CalendarUserDao;
import ec.com.technoloqie.securityspring.entities.CalendarUser;

//@Component("calendarUserDetailsService")
@Service("userDetailsService")
public class CalendarUserDetailsService implements UserDetailsService{
	@Autowired
	private CalendarUserDao calendarUserDao;
	
	/*@Autowired
	public CalendarUserDetailsService(CalendarUserDao calendarUserDao) {
	this.calendarUserDao = calendarUserDao;
	}*/
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
			CalendarUser user = calendarUserDao.findUserByEmail(username);
			if (user == null) {
			throw new UsernameNotFoundException("Invalidousername/password.");
			}
			Collection<? extends GrantedAuthority> authorities = CalendarUserAuthorityUtils.createAuthorities(user);
			return new User(user.getEmail(), user.getPassword(), authorities);
	}

	public CalendarUserDao getCalendarUserDao() {
		return calendarUserDao;
	}

}
