package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.Year;

public record StudentUser(
		 long ID,
		 String name,
		 long class_belongs,
		char gender,
		Year start_year,
		 String political_outlook,
		 String email,
		 Date birthdate,
		 Integer zip_code
		) implements Serializable {
	public static final DataClassRowMapper<StudentUser> MAPPER = DataClassRowMapper.newInstance(StudentUser.class);
	@Serial
	private static final long serialVersionUID = -806210434598551049L;
}
