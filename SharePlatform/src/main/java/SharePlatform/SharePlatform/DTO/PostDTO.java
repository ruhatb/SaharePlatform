package SharePlatform.SharePlatform.DTO;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String text;
    private String imageUrl;
    private Long userId;
}
