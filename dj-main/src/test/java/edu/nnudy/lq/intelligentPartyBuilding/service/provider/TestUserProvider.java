package edu.nnudy.lq.intelligentPartyBuilding.service.provider;


import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.impl.DefaultUserAuthenticationDAOImpl;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
//@DataJdbcTest
//@Import({UserAuthenticationDAO.class, DefaultUserAuthenticationDAOImpl.class})
class TestUserProvider {
	@Value("#{userAuthenticationDAO}")
	private UserAuthenticationDAO userAuthenticationDAO;
	@Test
	void testUserProvider() {
		Assertions.assertDoesNotThrow(() -> {
			Assertions.assertEquals(0, userAuthenticationDAO.count());
		});
	}
}
