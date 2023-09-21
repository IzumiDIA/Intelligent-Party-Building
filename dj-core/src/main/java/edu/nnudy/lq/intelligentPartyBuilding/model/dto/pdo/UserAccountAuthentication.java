package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

public record UserAccountAuthentication(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull RoleType role_type,
		@NonNull byte[] password
		) implements Serializable {
	public static final DataClassRowMapper<UserAccountAuthentication> MAPPER = DataClassRowMapper.newInstance(UserAccountAuthentication.class);
	@Serial
	private static final long serialVersionUID = 5115064384771074245L;
}
