package SharePlatform.SharePlatform.Repository;

import SharePlatform.SharePlatform.Entity.Posts;
import SharePlatform.SharePlatform.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByUser(Users user);
}
