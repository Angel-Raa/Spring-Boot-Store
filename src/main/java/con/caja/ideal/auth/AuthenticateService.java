package con.caja.ideal.auth;

import con.caja.ideal.jwt.JwtService;
import con.caja.ideal.models.Role;
import con.caja.ideal.models.UserModels;
import con.caja.ideal.repository.IUserRepository;
import con.caja.ideal.token.ITokeRepository;
import con.caja.ideal.token.TokenModels;
import con.caja.ideal.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
    @Autowired
    private IUserRepository repository;
    @Autowired
    private ITokeRepository tokenRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager manager;

    public AuthenticateResponse register(RegisterRequest request){
        var userDetails = UserModels.builder()
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var user = repository.save(userDetails);
        var jwtToken = jwtService.generateToken(userDetails);
        var token = TokenModels.builder()
                .userModels(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticateResponse authenticate(AuthenticateRequest authentication){
        manager.authenticate(new UsernamePasswordAuthenticationToken(authentication.getEmail(), authentication.getPassword()));
        var user = repository.findByEmail(authentication.getEmail()).orElseThrow();
        var userSave = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var token = TokenModels.builder()
                .expired(false)
                .revoked(false)
                .tokenType(TokenType.BEARER)
                .token(jwtToken)
                .userModels(userSave)
                .build();
        tokenRepository.save(token);
        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }
}
