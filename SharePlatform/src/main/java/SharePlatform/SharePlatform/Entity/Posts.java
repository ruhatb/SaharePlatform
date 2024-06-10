package SharePlatform.SharePlatform.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "text")
    private String text;

     @Column(name = "image_url")
    private String imageUrl;


     @ManyToOne

     @JoinColumn(name = "user_id", nullable = false)

     private Users user;
}
