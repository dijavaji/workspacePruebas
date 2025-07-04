package ec.com.technoloqe.securityanotation.utils;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import ec.com.technoloqe.securityanotation.entities.TechUser;

public class TechUserAuthorityUtils {
	private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
    private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    private static final List<GrantedAuthority> DBA_ROLES = AuthorityUtils.createAuthorityList("ROLE_DBA");
    
    public static Collection<? extends GrantedAuthority> createAuthorities(TechUser calendarUser) {
        String username = calendarUser.getEmail();
        if (username.startsWith("admin")) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }

    private TechUserAuthorityUtils() {
    }
}
