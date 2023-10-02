package edu.nnudy.lq.dj.service.provider;


import edu.nnudy.lq.dj.constant.enums.RoleType;
import edu.nnudy.lq.dj.manager.intf.UserManager;
import edu.nnudy.lq.dj.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.dj.model.dto.pdo.UserAccountAuthentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Import({UserAuthenticationDAO.class, DefaultUserAuthenticationDAOImpl.class})
class TestUserProvider {
	@Value("#{userAuthenticationDAO}")
	private UserAuthenticationDAO userAuthenticationDAO;
	@Value("#{userManager}")
	private UserManager userManager;
	@Test
	void testUserProvider() {
		Assertions.assertDoesNotThrow(() -> {
			Assertions.assertEquals(0, userManager.count());
			Assertions.assertFalse(
					userManager.isExisting(
							new UserAccountAuthentication(
									12345678,
									RoleType.ADMINISTRATOR,
									new byte[32]
							)
					)
			);
		});
	}
}
