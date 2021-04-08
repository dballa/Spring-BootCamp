package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import converter.UserConverter;
import dto.ResponseTestExternalAPI;
import dto.UserFilter;
import dto.UserToCreateDto;
import dto.UserToUpdateDto;
import entity.RoleEntity;
import entity.UserEntity;
import repository.RoleRepositoryInterface;
import repository.UserRepositoryInterface;
import exceptions.CustomUserException;

@Service
@Transactional
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepositoryInterface userRepository;
	
	@Autowired
	RoleRepositoryInterface roleRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${ageAllowedToAdd}")
	private int ageAllowedToAdd;
	
	private String URL = "https://jsonplaceholder.typicode.com/todos/1";
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public UserEntity insertUser(UserToCreateDto user) {
		
		logger.info("Inserting user {}", user);
		
		if (user != null) {
			
			if (user.getFirstName() != null) {
				
				if (user.getLastName() != null) {
					
					if (Period.between(user.getBirthdate(), LocalDate.now()).getYears() > ageAllowedToAdd) {
						RoleEntity roleFound = roleRepository.getRoleByUserId(user.getId());
						UserEntity userToAdd = UserConverter.toEntityToCreate(user, roleFound);
						userRepository.addUser(userToAdd);
						return userToAdd;
					} else {
						throw new CustomUserException("Registration not allowed because minimal age is " + ageAllowedToAdd
								+ " but user to add age is " + Period.between(user.getBirthdate(), LocalDate.now()).getYears());
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
	public List<UserEntity> getAllUsers(String name) {
		
		if (name != null && !name.isEmpty()) {

			return userRepository.getUserByName(name);
		}else{
			return userRepository.getAllEnabledUsers();
		}
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

	@Override
	public void testRest() {
		ResponseEntity<ResponseTestExternalAPI> response = restTemplate.exchange(URL, HttpMethod.GET, null, ResponseTestExternalAPI.class);
		
		ResponseTestExternalAPI responseTestExternalAPI= response.getBody();

		System.out.println(responseTestExternalAPI);
	}

	@Override
	public List<UserEntity> getUsers(UserFilter filter) {

		logger.info("Filtring users with filter {}", filter);
		return userRepository.getUsers(filter);

	}

}
