package com.redSocial.redSocial.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redSocial.redSocial.dto.UsuarioDTO;
import com.redSocial.redSocial.repository.UsuarioRepository;

@Service //definir la clase como un servicio
public class UsuarioService {

    @Autowired//evita usar el contructor directamente
    private UsuarioRepository usuarioRepository;
    
    //metodo para obtener los usuarios
    public List<UsuarioDTO> obtenerUsuarios(){
        return usuarioRepository.findAll()
            .stream()
            .map(usuario -> UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .fechaCreacion(usuario.getFechaCreacion())
                .build())
            .collect(Collectors.toList());    
    }
}
