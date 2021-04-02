package service;

import java.util.List;

import dto.UserToCreateDto;
import dto.UserToUpdateDto;
import entity.UserEntity;

public interface UserServiceInterface {

	UserEntity insertUser(UserToCreateDto user);

	List<UserEntity> getAllUsers();

	UserEntity updateUser(UserToUpdateDto user);

	void deleteUserSoft(int id);

	void deleteUserHard(int id);

	UserEntity findUser(int id);

}