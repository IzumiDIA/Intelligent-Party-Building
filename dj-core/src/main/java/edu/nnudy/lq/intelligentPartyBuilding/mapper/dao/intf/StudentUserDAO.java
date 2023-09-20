package edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf;

public interface StudentUserDAO extends DataAccessObject {
	Integer countWholeClassStudents( final long class_ID);
}
