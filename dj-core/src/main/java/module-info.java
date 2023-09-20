import edu.nnudy.lq.intelligentPartyBuilding.manager.intf.*;
import edu.nnudy.lq.intelligentPartyBuilding.service.intf.*;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.*;

/**
 * Core business module.
 */
module dj.core {
	requires org.jetbrains.annotations;
	requires static lombok;
	requires java.sql;
	requires dj.shared;
	requires spring.core;
	requires spring.context;
	requires spring.web;
	requires spring.security.config;
	requires spring.security.web;
	requires spring.jdbc;
	requires com.fasterxml.jackson.databind;
	
	exports edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;
	exports edu.nnudy.lq.intelligentPartyBuilding.manager.intf;
	exports edu.nnudy.lq.intelligentPartyBuilding.service.intf;
	exports edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;
	exports edu.nnudy.lq.intelligentPartyBuilding.filter;
	
	uses HelloWorldService;
	uses UserAuthenticationDAO;
	uses UserManager;
}
