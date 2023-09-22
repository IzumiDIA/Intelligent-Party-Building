package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

import org.jetbrains.annotations.Range;

public interface StudentUserDAO extends DataAccessObject {
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer countWholeClassStudents(final @Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) long class_ID);
}
