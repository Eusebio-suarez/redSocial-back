package com.redSocial.redSocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redSocial.redSocial.dto.UsuarioDTO;
import com.redSocial.redSocial.repository.UsuarioRepository;

@Service //definir la clase como un servicio
public class UsuarioService {

    @Autowired//evita usar el contructor directamente
    private UsuarioRepository usuarioRepository;
    
    public List<UsuarioDTO> obtenerUsuarios(){
        return usuarioRepository.findAll()
            .stream()
            .map(usuario -> UsuarioDTO.builder()
                .correo(usuario.getCorreo())
                .nombre(nombre)
            )
    }
}
