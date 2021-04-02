package repository;

import entity.RoleEntity;

public interface RoleRepositoryInterface {

	RoleEntity getRoleByUserId(int id);

	void addSubscription(RoleEntity roleEntity);

}