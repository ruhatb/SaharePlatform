package SharePlatform.SharePlatform.Converter;

import SharePlatform.SharePlatform.DTO.UserDTO;
import SharePlatform.SharePlatform.Entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO convertToDTO(Users user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public Users convertToEntity(UserDTO dto) {
        Users user = new Users();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        return user;
    }
}
