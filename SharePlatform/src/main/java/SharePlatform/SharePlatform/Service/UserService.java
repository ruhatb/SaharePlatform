package SharePlatform.SharePlatform.Service;

import SharePlatform.SharePlatform.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    UserDTO findById(Long id);
    List<UserDTO> findAll();
}
