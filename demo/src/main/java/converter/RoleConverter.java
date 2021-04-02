package converter;

import dto.RoleDto;
import entity.RoleEntity;

public class RoleConverter {
	
	public static RoleDto toDto(RoleEntity entity) {
		RoleDto toReturn=new RoleDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		return toReturn;
	}
	
	public static RoleEntity toEntity (RoleDto dto) {
		RoleEntity toReturn=new RoleEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		return toReturn;
	}

}
