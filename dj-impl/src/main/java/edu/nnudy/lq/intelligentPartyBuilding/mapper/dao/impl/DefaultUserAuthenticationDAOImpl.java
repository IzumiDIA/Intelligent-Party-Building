package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.impl;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;
import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository("userAuthenticationDAO")
public class DefaultUserAuthenticationDAOImpl implements UserAuthenticationDAO {
	@NonNull
	private final JdbcTemplate jdbcTemplate;
	
	public DefaultUserAuthenticationDAOImpl(@NonNull JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public @Range(from = 0, to = Integer.MAX_VALUE) Integer count() {
		return jdbcTemplate.queryForObject(
				"SELECT count(*) FROM `user_account_authentication`;", Integer.TYPE
		);
	}
	
	@Override
	public @Range(from = 0, to = Integer.MAX_VALUE) Integer count(@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1) final long ID) {
		return jdbcTemplate.queryForObject(
				"SELECT count(*) FROM `user_account_authentication` WHERE ID = ?;",
				Integer.TYPE,
				ID
		);
	}
	
	@Override
	public Boolean isExisting(@NonNull final UserAccountAuthentication authentication) {
		return jdbcTemplate.queryForObject(
				"SELECT EXISTS(SELECT * FROM user_account_authentication WHERE (ID, role_type, password) = (?, ?, ?));",
				Boolean.TYPE,
				authentication.ID(),
				authentication.role_type(),
				authentication.password()
		);
	}
	
	@Override
	public int updatePassword(@NonNull final UserAccountAuthentication authentication, @NonNull final byte[] newPassword) {
		return jdbcTemplate.update(
				"UPDATE user_account_authentication SET password = ? WHERE (ID, role_type, password) = (?, ?, ?);",
				newPassword,
				authentication.ID(),
				authentication.role_type(),
				authentication.password()
		);
	}
	
	@Override
	public int updateRoleType(@NonNull final UserAccountAuthentication authentication, @NonNull final RoleType newRoleType) {
		return jdbcTemplate.update(
				"UPDATE user_account_authentication SET role_type = ? WHERE (ID, role_type, password) = (?, ?, ?);",
				newRoleType,
				authentication.ID(),
				authentication.role_type(),
				authentication.password()
		);
	}
}