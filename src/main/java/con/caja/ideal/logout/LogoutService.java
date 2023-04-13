package con.caja.ideal.logout;

import con.caja.ideal.token.ITokeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {
    @Autowired
    private ITokeRepository repository;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String email;
        if (authHeader != null || !authHeader.startsWith("Bearer")){
            return;
        }
        String jwt = authHeader.substring(7);
        var storeToken = repository.findByToken(jwt)
                .orElse(null);
        if (storeToken != null) {
            storeToken.setExpired(true);
            storeToken.setExpired(true);
            repository.save(storeToken);
        }
    }
}
