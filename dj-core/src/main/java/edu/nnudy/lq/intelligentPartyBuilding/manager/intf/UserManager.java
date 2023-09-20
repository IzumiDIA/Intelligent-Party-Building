package edu.nnudy.lq.intelligentPartyBuilding.manager.intf;

import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;

public interface UserManager {
	int count();
	int count( final long ID);
	boolean isExisting( final UserAccountAuthentication authentication);
}
