package edu.nnudy.lq.dj.mapper.dao.intf;

import org.jetbrains.annotations.Range;

public interface DataAccessObject {
	@Range(from = 0, to = Integer.MAX_VALUE)
	Integer count();
}
