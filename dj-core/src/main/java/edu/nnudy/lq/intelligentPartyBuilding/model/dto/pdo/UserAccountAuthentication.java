package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;

public record UserAccountAuthentication(
		 long ID,
		 RoleType role_type,
		 byte[] password
		) implements Serializable {
	public static final DataClassRowMapper<UserAccountAuthentication> MAPPER = DataClassRowMapper.newInstance(UserAccountAuthentication.class);
	@Serial
	private static final long serialVersionUID = 5115064384771074245L;
}
