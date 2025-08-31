package com.redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redSocial.redSocial.entity.Usuario;

@Repository//definir la clase como un repositorio
public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
