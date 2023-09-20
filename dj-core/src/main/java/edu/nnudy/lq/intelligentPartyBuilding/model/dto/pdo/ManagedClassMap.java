package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;

public record ManagedClassMap(
		 long class_ID,
		 long ID
		) implements Serializable {
	public static final DataClassRowMapper<ManagedClassMap> MAPPER = DataClassRowMapper.newInstance(ManagedClassMap.class);
	
	@Serial
	private static final long serialVersionUID = -8279950443295812760L;
}
