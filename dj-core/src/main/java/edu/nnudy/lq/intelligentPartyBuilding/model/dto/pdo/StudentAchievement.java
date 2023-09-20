package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;

public record StudentAchievement(
		 long ID,
		double CET_score,
		 String CRE_grade,
		JsonNode personal_comprehensive_quality_assessment
) implements Serializable {
	public static final DataClassRowMapper<StudentAchievement> MAPPER = DataClassRowMapper.newInstance(StudentAchievement.class);
	@Serial
	private static final long serialVersionUID = 8057056263916124863L;
}
