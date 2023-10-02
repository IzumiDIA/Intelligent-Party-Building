package edu.nnudy.lq.dj.mapper.dao.provider;

import edu.nnudy.lq.dj.mapper.dao.intf.UserAuthenticationDAO;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;

public final class UserAuthenticationDAOProvider {
	private UserAuthenticationDAOProvider() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
	public static UserAuthenticationDAO provider() {
		return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext())
				       .getBean(
						       "userAuthenticationDAO",
						       UserAuthenticationDAO.class
				       );
	}
}
