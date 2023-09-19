package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.provider;

import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;

@UtilityClass
public class UserAuthenticationDAOProvider {
	public UserAuthenticationDAO provider() {
		return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext()).getBean("userAuthenticationDAO", UserAuthenticationDAO.class);
//		return null;
	}
}
