package com.redSocial.redSocial.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redSocial.redSocial.dto.UsuarioRequestDTO;
import com.redSocial.redSocial.dto.UsuarioResponseDTO;
import com.redSocial.redSocial.entity.Usuario;
import com.redSocial.redSocial.repository.UsuarioRepository;

@Service //definir la clase como un servicio
public class UsuarioService {

    @Autowired//evita usar el contructor directamente
    private UsuarioRepository usuarioRepository;
    
    //metodo para obtener los usuarios
    public List<UsuarioResponseDTO> obtenerUsuarios(){
        //se obtienen todos los usuarios d ela base de datos
        return usuarioRepository.findAll()
            .stream()
            //se mapean los usuarios y se convierte a usuario de tipo response solo con la informacion necesaria
            .map(usuario -> UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .fechaCreacion(usuario.getFechaCreacion())
                .build())
            .collect(Collectors.toList());    
    }

    //metodo para guardar un nuevo usuario
    public UsuarioResponseDTO registarUsuario(UsuarioRequestDTO usuarioRequestDto){
        //obtener la informacion del usuario para hacer la insercion en la base de datos
        //se crea una instacia del usuario con los datos de usuario request
        Usuario usuario = Usuario.builder()
                        .nombre(usuarioRequestDto.getNombre())
                        .correo(usuarioRequestDto.getCorreo())
                        .contraseña(usuarioRequestDto.getContraseña())
                        .fechaCreacion(LocalDateTime.now())
                        .build();

        //registar un nuevo usuario en la base de datos para poder obtener su id y fecha de creacion
        Usuario usuarioregistrado = usuarioRepository.save(usuario);

        //responder con usuario de tipo response solo con la informacion necesaria
        return UsuarioResponseDTO.builder()
                        .id(usuarioregistrado.getId())
                        .nombre(usuarioregistrado.getNombre())
                        .correo(usuarioregistrado.getCorreo())
                        .fechaCreacion(usuarioregistrado.getFechaCreacion())
                        .build();
                    
    }
}
