package edu.nnudy.lq.intelligentPartyBuilding.manager.intf;

import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;

public interface UserManager {
	@Range(from = 0, to = Integer.MAX_VALUE)
	int count();
	@Range(from = 0, to = Integer.MAX_VALUE)
	int count(@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1) final long ID);
	boolean isExisting(@NonNull final UserAccountAuthentication authentication);
}
