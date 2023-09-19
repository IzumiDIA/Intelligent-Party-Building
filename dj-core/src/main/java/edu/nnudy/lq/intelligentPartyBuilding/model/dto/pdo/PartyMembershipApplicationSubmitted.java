package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.Range;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

public record PartyMembershipApplicationSubmitted(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull String section,
		@Range(from = 0, to = 31) byte node,
		@NonNull Time submit_date_time,
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long approver_ID,
		JsonNode form
) implements Serializable {
	public static final DataClassRowMapper<PartyMembershipApplicationSubmitted> MAPPER = DataClassRowMapper.newInstance(PartyMembershipApplicationSubmitted.class);
	
	@Serial
	private static final long serialVersionUID = 4799041578911380115L;
}
