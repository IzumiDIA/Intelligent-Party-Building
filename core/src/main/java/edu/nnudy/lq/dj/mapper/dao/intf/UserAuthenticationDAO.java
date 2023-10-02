package edu.nnudy.lq.dj.mapper.dao.intf;

import edu.nnudy.lq.dj.constant.enums.RoleType;
import edu.nnudy.lq.dj.model.dto.pdo.UserAccountAuthentication;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface UserAuthenticationDAO extends DataAccessObject {
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer count();
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer count(final @Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID);
	Boolean isExisting(@NonNull final UserAccountAuthentication authentication);
	@Nullable
	UserAccountAuthentication findUser(
			final @Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
			final @NonNull RoleType roleType
	);
	int updatePassword(@NonNull final UserAccountAuthentication authentication, @NonNull final byte[] newPassword);
	int updateRoleType(@NonNull final UserAccountAuthentication authentication, @NonNull final RoleType newRoleType);
	int insertUserAuth(@NonNull final UserAccountAuthentication newAuthentication);
}
