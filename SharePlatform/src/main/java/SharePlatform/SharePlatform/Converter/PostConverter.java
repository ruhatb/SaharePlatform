package SharePlatform.SharePlatform.Converter;

import SharePlatform.SharePlatform.DTO.PostDTO;
import SharePlatform.SharePlatform.Entity.Posts;
import SharePlatform.SharePlatform.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    @Autowired
    private UserConverter userConverter;

    public PostDTO convertToDTO(Posts post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setText(post.getText());
        dto.setImageUrl(post.getImageUrl());
        dto.setUserId(post.getUser().getId());
        return dto;
    }

    public Posts convertToEntity(PostDTO dto, Users user) {
        Posts post = new Posts();
        post.setId(dto.getId());
        post.setText(dto.getText());
        post.setImageUrl(dto.getImageUrl());
        post.setUser(user);
        return post;
    }
}
