package edu.nnudy.lq.dj.manager.impl;

import edu.nnudy.lq.dj.manager.intf.UserManager;
import edu.nnudy.lq.dj.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.dj.model.dto.pdo.UserAccountAuthentication;
import org.jetbrains.annotations.Range;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository("userManager")
public class DefaultUserManagerImpl implements UserManager {
	@NonNull
	private final UserAuthenticationDAO userAuthenticationDAO;
	
	public DefaultUserManagerImpl(@NonNull final UserAuthenticationDAO userAuthenticationDAO) {
		this.userAuthenticationDAO = userAuthenticationDAO;
	}
	
	@Override
	public @Range(from = 0, to = Integer.MAX_VALUE) int count() {
		return Objects.requireNonNull(userAuthenticationDAO.count(), "Count error!");
	}
	
	@Override
	public @Range(from = 0, to = Integer.MAX_VALUE) int count(@Range(from = 0, to = ((long) Integer.MAX_VALUE) << 1) final long ID) {
		return Objects.requireNonNull(userAuthenticationDAO.count(ID), STR."Parameter [\{ID}] can not query any value!");
	}
	
	@Override
	public boolean isExisting(@NonNull final UserAccountAuthentication authentication) {
		return Objects.requireNonNull(userAuthenticationDAO.isExisting(authentication));
	}
}
