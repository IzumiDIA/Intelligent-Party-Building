package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface UserAuthenticationDAO extends DataAccessObject {
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer count();
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer count(@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1) final long ID);
	Boolean isExisting(@NonNull final UserAccountAuthentication authentication);
	@Nullable
	UserAccountAuthentication findUser(
			@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1) final long ID,
			@NonNull final RoleType roleType
	);
	int updatePassword(@NonNull final UserAccountAuthentication authentication, @NonNull final byte[] newPassword);
	int updateRoleType(@NonNull final UserAccountAuthentication authentication, @NonNull final RoleType newRoleType);
	int insertUserAuth(@NonNull final UserAccountAuthentication newAuthentication);
}
