package com.rplproject.myblog.services;

import com.rplproject.myblog.secutiry.UsuariosSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static UsuariosSecurity authenticated() {
        try {
            return (UsuariosSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
