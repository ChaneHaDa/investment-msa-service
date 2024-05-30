package com.chan.investment.authorization_server.controller;

import com.chan.investment.authorization_server.dto.AuthenticateReturnDTO;
import com.chan.investment.authorization_server.dto.AuthorizationReturnDTO;
import com.chan.investment.authorization_server.jpa.dto.CustomerDTO;
import com.chan.investment.authorization_server.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticationController {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationConfiguration authenticationConfiguration, JwtUtil jwtUtil) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticaion")
    public ResponseEntity<AuthenticateReturnDTO> authenticate(@RequestBody CustomerDTO customerDTO) throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken(customerDTO.getUsername(), customerDTO.getPassword());
        authentication = authenticationConfiguration.getAuthenticationManager().authenticate(authentication);
        String jwt = jwtUtil.generateToken(authentication.getName());
        return ResponseEntity.ok(new AuthenticateReturnDTO(jwt, jwtUtil.extractExpiration(jwt).toString()));
    }

    @PostMapping("/authorization")
    public ResponseEntity<AuthorizationReturnDTO> authorization(@RequestHeader HttpHeaders header) {
        String token = header.getFirst("Authorization").replace("Bearer ", "");
        String username = jwtUtil.extractUsername(token);
        AuthorizationReturnDTO authorizationReturnDTO;
        if(jwtUtil.validateToken(token, username)){
            authorizationReturnDTO = new AuthorizationReturnDTO("Authorized", username);
        } else {
            authorizationReturnDTO = new AuthorizationReturnDTO("Unauthorized", username);
        }
        return ResponseEntity.ok(authorizationReturnDTO);
    }

}
