package con.caja.ideal.repository;

import con.caja.ideal.models.ProductModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductModels, Long> {
    Optional<ProductModels> findByName(String name);

}
