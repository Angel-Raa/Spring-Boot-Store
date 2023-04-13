package con.caja.ideal.repository;

import con.caja.ideal.models.CategoryModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository  extends JpaRepository<CategoryModels, Long> {
    Optional<CategoryModels> findByName(String name);
}
