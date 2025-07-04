package ec.com.technoloqe.securityanotation.dao;

import ec.com.technoloqe.securityanotation.entities.TechUser;

public interface TechUserDao {
	public TechUser findByUserName(String username);
}
