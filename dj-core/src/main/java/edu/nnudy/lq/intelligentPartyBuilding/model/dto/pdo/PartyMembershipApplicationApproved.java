package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

public record PartyMembershipApplicationApproved(
		 long ID,
		 String section,
		 byte node,
		 Time submit_date_time,
		 long approver_ID,
		JsonNode form
) implements Serializable {
	public static final DataClassRowMapper<PartyMembershipApplicationApproved> MAPPER = DataClassRowMapper.newInstance(PartyMembershipApplicationApproved.class);
	
	@Serial
	private static final long serialVersionUID = -8966079962131992654L;
}
