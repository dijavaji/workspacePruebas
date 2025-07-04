package ec.com.technoloqe.securityanotation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.com.technoloqe.securityanotation.dao.TechUserDao;
import ec.com.technoloqe.securityanotation.entities.TechUser;
import ec.com.technoloqe.securityanotation.utils.TechUserAuthorityUtils;

@Service("userDetailsService")
public class MyUserDetailsService  implements UserDetailsService{
	
	//get user from the database, via Hibernate
	@Autowired
	private TechUserDao userDao;

	//@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/**TechUser user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

		return buildUserForAuthentication(user, authorities);*/
		TechUser user = userDao.findByUserName(username);
		if (user == null) {
		throw new UsernameNotFoundException("Invalidusername/password.");
		}
		Collection<? extends GrantedAuthority> authorities = TechUserAuthorityUtils.createAuthorities(user);
		return new User(user.getEmail(), user.getPassword(), authorities);
		
		
	}
	
	// Converts com.mkyong.users.model.User user to
		// org.springframework.security.core.userdetails.User
		private User buildUserForAuthentication(TechUser user, List<GrantedAuthority> authorities) {
			return new User(user.getFirstName(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
		}

		/**private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

			// Build user's authorities
			for (UserRole userRole : userRoles) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			}

			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

			return Result;
		}**/

}
