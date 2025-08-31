package com.redSocial.redSocial.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Entity//definir la colase como una entidad
@Data//geters y setters con lombuk
@Table(name="usuarios")//nombre de la tabla en la base de datos
@Builder//permite usar el patron builder contructores
public class Usuario {
    
    @Id//clave primaride la tabla
    @GeneratedValue(strategy= GenerationType.IDENTITY)//la base de datos genera el id
    private Long id;

    @Column(name="nombre")
    @NotBlank // valida que el cmapo no este vacio
    @Size(min=3,max=20,message="el nomre debe tener minimmo 3 y maximo 20 caracteres")
    private String nombre;

    @Column(name="correo")
    @NotBlank // valida que el cmapo no este vacio
    //validar que este en un rango de datos de lo contario muestra el mensaje
    @Size(max=30,message="el correo debe tener maximo 30 caracteres")
    private String correo;

    @Column(name="contraseña")
    @NotBlank // valida que el cmapo no este vacio
    @Size(min=8,max=20,message="la contraseña debe tener minimo 4 y maximo 20 caracteres")
    private String contraseña;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

}
