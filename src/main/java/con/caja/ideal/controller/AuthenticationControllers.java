package con.caja.ideal.controller;

import con.caja.ideal.auth.AuthenticateRequest;
import con.caja.ideal.auth.AuthenticateResponse;
import con.caja.ideal.auth.AuthenticateService;
import con.caja.ideal.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1/user")
public class AuthenticationControllers {
    @Autowired
    private AuthenticateService service;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AuthenticateResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
