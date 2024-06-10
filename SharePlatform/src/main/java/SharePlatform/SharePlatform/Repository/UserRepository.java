package SharePlatform.SharePlatform.Repository;


import SharePlatform.SharePlatform.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
