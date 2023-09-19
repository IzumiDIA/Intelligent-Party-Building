package edu.nnudy.lq.intelligentPartyBuilding.manager.provider;

import edu.nnudy.lq.intelligentPartyBuilding.manager.intf.UserManager;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;

@UtilityClass
public class UserManagerProvider {
	public UserManager provider() {
		return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext())
				       .getBean(
						       "userManager",
						       UserManager.class
				       );
	}
}
