package com.webtecnology.app.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.webtecnology.app.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAutenticado implements UserDetails {
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> autoAuthorities;
    public static UsuarioAutenticado construir(Usuario usuario) {
         Collection<GrantedAuthority> authority = new ArrayList<>();
         authority.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        return new UsuarioAutenticado(usuario.getEmail(),usuario.getPassword(),authority);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autoAuthorities;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getUsername() {
        return email;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
}
