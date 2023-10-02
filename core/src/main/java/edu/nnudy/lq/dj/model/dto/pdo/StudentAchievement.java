package edu.nnudy.lq.dj.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

public record StudentAchievement(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		double CET_score,
		@NonNull String CRE_grade,
		JsonNode personal_comprehensive_quality_assessment
) implements Serializable {
	public static final DataClassRowMapper<StudentAchievement> MAPPER = DataClassRowMapper.newInstance(StudentAchievement.class);
	@Serial
	private static final long serialVersionUID = 8057056263916124863L;
}
