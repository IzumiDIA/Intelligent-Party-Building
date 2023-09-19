package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

import org.jetbrains.annotations.Range;

public interface StudentUserDAO extends DataAccessObject {
	Integer countWholeClassStudents(@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1 ) final long class_ID);
}
