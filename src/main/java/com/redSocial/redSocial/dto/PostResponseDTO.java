package com.redSocial.redSocial.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder//permite usar el patro builder
@Data//getters y setter  con lombuk
public class PostResponseDTO {
    private String contenido;
    private String imagenUrl;
    private LocalDateTime fechaCreacion;
    private UsuarioResponseDTO usuario;
}
