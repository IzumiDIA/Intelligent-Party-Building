package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;

public interface UserAuthenticationDAO extends DataAccessObject {
	
	Integer count();
	
	Integer count( final long ID);
	Boolean isExisting( final UserAccountAuthentication authentication);
	
	UserAccountAuthentication findUser(
			 final long ID,
			 final RoleType roleType
	);
	int updatePassword( final UserAccountAuthentication authentication,  final byte[] newPassword);
	int updateRoleType( final UserAccountAuthentication authentication,  final RoleType newRoleType);
	int insertUserAuth( final UserAccountAuthentication newAuthentication);
}
