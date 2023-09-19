package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import edu.nnudy.lq.intelligentPartyBuilding.constant.enums.PrivilegeLevel;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;

public record PowerUser(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID,
		@NonNull PrivilegeLevel privilege_level,
		@NonNull String name,
		char gender
		) {
}
