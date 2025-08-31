package com.redSocial.redSocial.dto;

import lombok.Builder;
import lombok.Data;


@Builder//permite utilizar el patron builder (constructores)
@Data//getters y setters con lombuk
public class UsuarioRequestDTO {
    private String nombre;
    private String correo;
    private String contraseña;
}
