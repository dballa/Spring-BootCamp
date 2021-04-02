package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import converter.UserConverter;
import dto.UserToCreateDto;
import dto.UserToUpdateDto;
import entity.RoleEntity;
import entity.UserEntity;
import repository.RoleRepositoryInterface;
import repository.UserRepositoryInterface;
import util.CustomUserException;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepositoryInterface userRepository;
	
	@Autowired
	RoleRepositoryInterface roleRepository;

	@Value("${ageAllowedToAdd}")
	private int ageAllowedToAdd;

	@Override
	public UserEntity insertUser(UserToCreateDto user) {
		
		if (user != null) {
			if (user.getFirstName() != null) {
				if (user.getLastName() != null) {
					if (Period.between(user.getBirthdate(), LocalDate.now()).getYears() > ageAllowedToAdd) {
						RoleEntity roleFound = roleRepository.getRoleByUserId(user.getId());
						UserEntity userToAdd = UserConverter.toEntityToCreate(user, roleFound);
						userRepository.addUser(userToAdd);
						return userToAdd;
					} else {
						System.out.println("Registration not allowed because minimal age is " + ageAllowedToAdd
								+ " but user to add age is " + Period.between(user.getBirthdate(), LocalDate.now()).getYears());
						throw new CustomUserException("Could not register user");
					}
				} else {
					System.out.println("Last name is mandatory");
					throw new CustomUserException("Last name is mandatory");

				}
			} else {
				System.out.println("First name is mandatory");
				throw new CustomUserException("First name is mandatory");
			}
		}
		return null;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.getAllEnabledUsers();
	}

	@Override
	public UserEntity findUser(int id) {
		if(userRepository.UserExists(id)) {
			throw new CustomUserException("User does not exist!");
		}else {
			return userRepository.getUserById(id);
		}
	}

	@Override
	public UserEntity updateUser(UserToUpdateDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserSoft(int id) {
		if(userRepository.UserExists(id)) {
			throw new CustomUserException("User does not exist!");
		} else {
			userRepository.softDeleteUser(userRepository.getUserById(id));
		}
	}
	
	@Override
	public void deleteUserHard(int id) {
		
		
		if(userRepository.UserExists(id)) {
			throw new CustomUserException("User does not exist!");
		} else {
			userRepository.hardDeleteUser(userRepository.getUserById(id));
		}
		
	}

}
