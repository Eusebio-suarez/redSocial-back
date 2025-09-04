package com.redSocial.redSocial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redSocial.redSocial.dto.PostResponseDTO;
import com.redSocial.redSocial.dto.UsuarioResponseDTO;
import com.redSocial.redSocial.repository.PostRepositoty;

@Service//definar la clase como un servicio
public class PostService {
    
    @Autowired//evita usar el constructor directamente
    private PostRepositoty postRepositoty;

    public List<PostResponseDTO> obtenerPublicaciones(){

        return postRepositoty.findAll()
            .stream()
            .map(post -> PostResponseDTO.builder()
                .contenido(post.getContenido())
                .fechaCreacion(post.getFechaCreacion())
                .imagenUrl(post.getImagenUrl())
                .usuario(
                    UsuarioResponseDTO.builder()
                    .nombre(post.getUsuario().getNombre())
                    .build()
                )
                .build()
            
            )
            .toList();
    }

}
