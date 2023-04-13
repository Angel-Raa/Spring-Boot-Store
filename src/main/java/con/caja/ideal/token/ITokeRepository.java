package con.caja.ideal.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ITokeRepository extends JpaRepository<TokenModels, Long> {
    Optional<TokenModels> findByToken(String token);
}

