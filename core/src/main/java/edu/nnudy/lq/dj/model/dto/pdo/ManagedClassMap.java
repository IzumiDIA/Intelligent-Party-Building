package edu.nnudy.lq.dj.model.dto.pdo;

import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;

public record ManagedClassMap(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long class_ID,
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID
		) implements Serializable {
	public static final DataClassRowMapper<ManagedClassMap> MAPPER = DataClassRowMapper.newInstance(ManagedClassMap.class);
	
	@Serial
	private static final long serialVersionUID = -8279950443295812760L;
}
