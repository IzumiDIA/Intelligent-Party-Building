package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.PrivilegeLevel;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;

public record PowerUser(
		 long ID,
		 PrivilegeLevel privilege_level,
		 String name,
		char gender
		) implements Serializable {
	public static final DataClassRowMapper<PowerUser> MAPPER = DataClassRowMapper.newInstance(PowerUser.class);
	@Serial
	private static final long serialVersionUID = -2209094563416167694L;
}
