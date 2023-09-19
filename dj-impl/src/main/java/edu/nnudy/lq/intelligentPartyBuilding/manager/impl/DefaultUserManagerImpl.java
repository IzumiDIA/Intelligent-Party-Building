package edu.nnudy.lq.intelligentPartyBuilding.manager.impl;

import edu.nnudy.lq.intelligentPartyBuilding.manager.intf.UserManager;
import edu.nnudy.lq.intelligentPartyBuilding.mapper.dao.intf.UserAuthenticationDAO;
import edu.nnudy.lq.intelligentPartyBuilding.model.dto.pdo.UserAccountAuthentication;
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
		return Objects.requireNonNull(userAuthenticationDAO.count(ID), "Parameter [" + ID + "] can not query any value!");
	}
	
	@Override
	public boolean isExisting(@NonNull final UserAccountAuthentication authentication) {
		return Objects.requireNonNull(userAuthenticationDAO.isExisting(authentication));
	}
}
