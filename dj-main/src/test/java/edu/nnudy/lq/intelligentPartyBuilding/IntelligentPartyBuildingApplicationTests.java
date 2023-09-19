package edu.nnudy.lq.intelligentPartyBuilding;

import edu.nnudy.lq.intelligentPartyBuilding.filter.WebSecurityConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntelligentPartyBuildingApplicationTests {
	
	@Test
	void contextLoads() {
		Assertions.assertDoesNotThrow(() -> Assertions.assertNotNull( WebSecurityConfig.class));
	}
	
}
