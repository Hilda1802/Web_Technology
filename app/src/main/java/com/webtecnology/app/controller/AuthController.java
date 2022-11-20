package com.webtecnology.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtecnology.app.dto.JwtDTO;
import com.webtecnology.app.dto.LoginUsuarioDTO;
import com.webtecnology.app.entity.Usuario;
import com.webtecnology.app.securityJwt.JwtProvider;
import com.webtecnology.app.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UsuarioService  usuarioService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO>login(@RequestBody LoginUsuarioDTO loginUsuario) {

       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generarToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return ResponseEntity.ok(jwtDto);
    }
}
