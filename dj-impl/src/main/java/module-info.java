import edu.nnudy.lq.intelligentPartyBuilding.manager.UserManagerProvider;
import edu.nnudy.lq.intelligentPartyBuilding.manager.intf.UserManager;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.provider.UserAuthenticationDAOProvider;
import edu.nnudy.lq.intelligentPartyBuilding.service.impl.DefaultHelloWorldServiceImpl;
import edu.nnudy.lq.intelligentPartyBuilding.service.intf.HelloWorldService;

/**
 * Specific implementation of core business module.
 * It is used through dependency injection.
 */
module dj.impl {
	requires static transitive dj.core;
	requires transitive dj.shared;
	requires spring.context;
	requires spring.jdbc;
	requires spring.core;
	requires spring.beans;
	requires spring.web;
	
	provides HelloWorldService with DefaultHelloWorldServiceImpl;
	provides UserAuthenticationDAO with UserAuthenticationDAOProvider;
	provides UserManager with UserManagerProvider;
}
