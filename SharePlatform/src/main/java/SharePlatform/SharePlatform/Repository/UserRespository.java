package SharePlatform.SharePlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
