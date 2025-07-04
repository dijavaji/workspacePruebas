package ec.com.technoloqie.securityspring.core.userdetails;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ec.com.technoloqie.securityspring.entities.CalendarUser;

public class CalendarUserDetails implements UserDetails{
	
	private static final long serialVersionUID = -8866829748888445188L;
	private CalendarUser user;
    private List<GrantedAuthority> authorities;
    
    public CalendarUserDetails(CalendarUser user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public CalendarUser getUser() {
		return user;
	}

	public void setUser(CalendarUser user) {
		this.user = user;
	}

}
