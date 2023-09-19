package edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo;

import org.jetbrains.annotations.Range;

public record Managed_class_map(
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long class_ID,
		@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long ID
		) {
}
