package SharePlatform.SharePlatform.Service;

import SharePlatform.SharePlatform.Converter.UserConverter;
import SharePlatform.SharePlatform.DTO.UserDTO;
import SharePlatform.SharePlatform.Entity.Users;
import SharePlatform.SharePlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO save(UserDTO userDTO) {
        Users user = userConverter.convertToEntity(userDTO);
        user = userRepository.save(user);
        return userConverter.convertToDTO(user);
    }
    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userConverter::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
