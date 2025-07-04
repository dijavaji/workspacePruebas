package ec.com.technoloqie.securityspring.dataaccess;

import java.util.List;

import org.springframework.stereotype.Repository;

import ec.com.technoloqie.securityspring.entities.CalendarUser;

@Repository
public class CalendarUserDaoImpl implements CalendarUserDao{

	@Override
	public CalendarUser getUser(int id) {
		CalendarUser calendarUser = new CalendarUser();
		calendarUser.setEmail("dvasquez@mail.com");
		calendarUser.setFirstName("dvasquez");
		calendarUser.setLastName("dvasquez");
		calendarUser.setPassword("123456");
		return calendarUser;
	}

	@Override
	public CalendarUser findUserByEmail(String email) {
		CalendarUser calendarUser = new CalendarUser();
		calendarUser.setEmail("dvasquez@mail.com");
		calendarUser.setFirstName("dvasquez");
		calendarUser.setLastName("dvasquez");
		calendarUser.setPassword("123456");
		return calendarUser;
	}

	@Override
	public List<CalendarUser> findUsersByEmail(String partialEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(CalendarUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
