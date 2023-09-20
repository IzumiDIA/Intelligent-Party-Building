package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

public record PartyMembershipApplicationSubmitted(
		 long ID,
		 String section,
		 byte node,
		 Time submit_date_time,
		 long approver_ID,
		JsonNode form
) implements Serializable {
	public static final DataClassRowMapper<PartyMembershipApplicationSubmitted> MAPPER = DataClassRowMapper.newInstance(PartyMembershipApplicationSubmitted.class);
	
	@Serial
	private static final long serialVersionUID = 4799041578911380115L;
}
