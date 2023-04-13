package con.caja.ideal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_db")
public class OrderModels implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amount;
    private long price;
    @Column(name = "shipping_address")
    private String ShippingAddress;
    private boolean state;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name ="client_id", referencedColumnName = "id")
    private UserModels userModels;
}
