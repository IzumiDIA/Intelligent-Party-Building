import edu.nnudy.lq.dj.manager.provider.UserManagerProvider;
import edu.nnudy.lq.dj.manager.intf.UserManager;
import edu.nnudy.lq.dj.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.dj.mapper.dao.provider.UserAuthenticationDAOProvider;
import edu.nnudy.lq.dj.service.impl.DefaultHelloWorldServiceImpl;
import edu.nnudy.lq.dj.service.intf.HelloWorldService;

/**
 * Specific implementation of core business module.
 * It is used through dependency injection.
 */
module impl {
	requires static transitive core;
	requires transitive common;
	requires spring.context;
	requires spring.jdbc;
	requires spring.core;
	requires spring.beans;
	requires spring.web;
	
	provides HelloWorldService with DefaultHelloWorldServiceImpl;
	provides UserAuthenticationDAO with UserAuthenticationDAOProvider;
	provides UserManager with UserManagerProvider;
}
