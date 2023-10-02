import edu.nnudy.lq.dj.manager.intf.*;
import edu.nnudy.lq.dj.service.intf.*;
import edu.nnudy.lq.dj.mapper.dao.intf.*;

/**
 * Core business module.
 */
module core {
	uses HelloWorldService;
	uses UserAuthenticationDAO;
	uses UserManager;

	requires transitive common;
	requires java.sql;
	requires spring.core;
	requires spring.context;
	requires spring.web;
	requires spring.security.config;
	requires spring.security.web;
	requires spring.jdbc;
	requires com.fasterxml.jackson.databind;
	
	exports edu.nnudy.lq.dj.mapper.dao.intf;
	exports edu.nnudy.lq.dj.manager.intf;
	exports edu.nnudy.lq.dj.service.intf;
	exports edu.nnudy.lq.dj.model.dto.pdo;
	exports edu.nnudy.lq.dj.filter;
}
