package con.caja.ideal.token;

import con.caja.ideal.models.UserModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class TokenModels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private boolean expired;
    private boolean revoked;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModels userModels;
}
