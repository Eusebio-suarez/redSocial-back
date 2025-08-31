package com.redSocial.redSocial.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;


@Builder//permite utilizar el patron builder (constructores)
@Data//getters y setters con lombuk
public class UsuarioRequestDTO {
    private String nombre;
    private String correo;
    private String contraseña;
}
