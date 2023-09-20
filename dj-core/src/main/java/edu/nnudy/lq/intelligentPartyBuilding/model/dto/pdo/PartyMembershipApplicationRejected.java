package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

public record PartyMembershipApplicationRejected(
		 long ID,
		 String section,
		 byte node,
		 Time submit_date_time,
		 long approver_ID,
		JsonNode form
) implements Serializable {
	public static final DataClassRowMapper<PartyMembershipApplicationRejected> MAPPER = DataClassRowMapper.newInstance(PartyMembershipApplicationRejected.class);
	
	@Serial
	private static final long serialVersionUID = 2289931029582550602L;
}
