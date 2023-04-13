package con.caja.ideal.repository;

import con.caja.ideal.models.OrderModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository  extends JpaRepository<OrderModels, Long > {
}
