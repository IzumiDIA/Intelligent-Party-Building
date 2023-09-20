package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.provider;

import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;


public final class UserAuthenticationDAOProvider {
	public static UserAuthenticationDAO provider() {
		return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext())
				       .getBean(
							   "userAuthenticationDAO",
						       UserAuthenticationDAO.class
				       );
	}
}
