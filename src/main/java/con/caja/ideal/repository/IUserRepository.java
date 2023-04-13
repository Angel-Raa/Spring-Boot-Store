package con.caja.ideal.repository;

import con.caja.ideal.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModels, Long> {
    Optional<UserModels> findByEmail(String email);
}
