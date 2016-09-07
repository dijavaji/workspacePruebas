package ec.com.technoloqie.securityspring.dataaccess;

import java.util.List;

import ec.com.technoloqie.securityspring.entities.CalendarUser;


public interface CalendarUserDao {
    public CalendarUser getUser(int id);
    
    public CalendarUser findUserByEmail(String email);
    
    public List<CalendarUser> findUsersByEmail(String partialEmail);
    
    public int createUser(CalendarUser user);
    
}
