package edu.nnudy.lq.dj.manager.provider;

import edu.nnudy.lq.dj.manager.intf.UserManager;
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
