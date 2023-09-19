package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.PrivilegeLevel;
import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

public record PowerUser(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull PrivilegeLevel privilege_level,
		@NonNull String name,
		char gender
		) implements Serializable {
	public static final DataClassRowMapper<PowerUser> MAPPER = DataClassRowMapper.newInstance(PowerUser.class);
	@Serial
	private static final long serialVersionUID = -2209094563416167694L;
}
