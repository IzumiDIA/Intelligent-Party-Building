package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.Year;

public record StudentUser(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull String name,
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long class_belongs,
		char gender,
		Year start_year,
		@NonNull String political_outlook,
		@NonNull String email,
		@NonNull Date birthdate,
		@Nullable Integer zip_code
		) implements Serializable {
	public static final DataClassRowMapper<StudentUser> MAPPER = DataClassRowMapper.newInstance(StudentUser.class);
	@Serial
	private static final long serialVersionUID = -806210434598551049L;
}
