package SharePlatform.SharePlatform.Service;

import SharePlatform.SharePlatform.DTO.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO save(PostDTO postDTO);
    PostDTO findById(Long id);
    List<PostDTO> findAll();
    List<PostDTO> findByUserId(Long userId);
}
