import edu.nnudy.lq.intelligentPartyBuilding.service.intf.*;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.*;

/**
 * Core business module.
 */
module dj.core {
	requires transitive org.jetbrains.annotations;
	requires static transitive lombok;
	requires transitive java.sql;
	requires transitive dj.shared;
	requires spring.core;
	requires spring.context;
	requires spring.web;
	requires spring.security.config;
	requires spring.security.web;
	
	exports edu.nnudy.lq.intelligentPartyBuilding.service.intf;
	exports edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;
	exports edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;
	exports edu.nnudy.lq.intelligentPartyBuilding.filter;
	
	uses HelloWorldService;
	uses UserAuthenticationDAO;
}