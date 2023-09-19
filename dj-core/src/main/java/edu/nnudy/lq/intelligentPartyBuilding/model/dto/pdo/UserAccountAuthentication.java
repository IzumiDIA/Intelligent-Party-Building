package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.RoleType;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;

public record UserAccountAuthentication(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull RoleType role_type,
		@NonNull byte[] password
		) {
}
