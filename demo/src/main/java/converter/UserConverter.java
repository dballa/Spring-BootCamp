package converter;

import dto.UserDto;
import dto.UserToCreateDto;
import entity.RoleEntity;
import entity.UserEntity;

public class UserConverter {


	public static UserDto toDto(UserEntity entity) {
		
		UserDto userToReturn = new UserDto();
		
		userToReturn.setId(entity.getId());
		userToReturn.setFirstName(entity.getFirstName());
		userToReturn.setLastName(entity.getLastName());
		userToReturn.setBirthdate(entity.getBirthdate());
		userToReturn.setEnabled(entity.isEnabled());
		userToReturn.setRole(RoleConverter.toDto(entity.getRole()));
		
		return userToReturn;
	}

	public static UserEntity toEntity(UserDto userDto) {
		
		UserEntity userEntityToReturn=new UserEntity();
		
		userEntityToReturn.setId(userDto.getId());
		userEntityToReturn.setFirstName(userDto.getFirstName());
		userEntityToReturn.setLastName(userDto.getLastName());
		userEntityToReturn.setBirthdate(userDto.getBirthdate());
		userEntityToReturn.setEnabled(userDto.isEnabled());
		userEntityToReturn.setRole(RoleConverter.toEntity(userDto.getRole()));
		
		return userEntityToReturn;
	}
	
	public static UserEntity toEntityToCreate(UserToCreateDto userToCreateDto, RoleEntity roleEntity) {
		
		UserEntity toReturn=new UserEntity();
		
		toReturn.setId(userToCreateDto.getId());
		toReturn.setFirstName(userToCreateDto.getFirstName());
		toReturn.setLastName(userToCreateDto.getLastName());
		toReturn.setBirthdate(userToCreateDto.getBirthdate());
		toReturn.setUsername(userToCreateDto.getUsername());
		toReturn.setPassword(userToCreateDto.getPassword());
		toReturn.setEnabled(userToCreateDto.isEnabled());
		toReturn.setRole(roleEntity);
		
		return toReturn;
	}

	public static UserDto toNewDto(Object updateUser) {
		// TODO Auto-generated method stub
		return null;
	}
}