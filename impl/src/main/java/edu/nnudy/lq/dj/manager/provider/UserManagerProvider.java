package edu.nnudy.lq.dj.manager.provider;

import edu.nnudy.lq.dj.manager.intf.UserManager;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;

public final class UserManagerProvider {
	private UserManagerProvider() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
	public static UserManager provider() {
		return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext())
				       .getBean(
						       "userManager",
						       UserManager.class
				       );
	}
}
