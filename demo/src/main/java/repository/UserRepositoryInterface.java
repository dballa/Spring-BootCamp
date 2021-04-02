package repository;

import java.util.List;

import entity.UserEntity;

public interface UserRepositoryInterface {

	List<UserEntity> getAllEnabledUsers();
	
	List<UserEntity> getAllEnabledStudents();

	UserEntity getUserById(int id);

	UserEntity getUserByUsername(String username);

	boolean UserExists(int id);

	void addUser(UserEntity user);

	void updateUser(UserEntity user);

	void softDeleteUser(UserEntity user);

	void hardDeleteUser(UserEntity user);

}