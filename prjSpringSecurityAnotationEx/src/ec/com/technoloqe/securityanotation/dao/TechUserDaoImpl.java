package ec.com.technoloqe.securityanotation.dao;

import org.springframework.stereotype.Repository;

import ec.com.technoloqe.securityanotation.entities.TechUser;

@Repository
public class TechUserDaoImpl implements TechUserDao{

	@Override
	public TechUser findByUserName(String username) {
		TechUser user = new TechUser();
		user.setFirstName("dvasquez");
		user.setEmail("dvasquez@prueba.com");
		user.setPassword("123456");
		return user;
	}

}
