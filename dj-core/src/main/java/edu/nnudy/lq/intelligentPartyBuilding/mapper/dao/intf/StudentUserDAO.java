package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

import org.jetbrains.annotations.Range;

public interface StudentUserDAO extends DataAccessObject {
	Integer countWholeClassStudents(final long class_ID);
}
