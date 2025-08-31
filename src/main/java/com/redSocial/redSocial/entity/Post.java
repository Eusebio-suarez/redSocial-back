package com.redSocial.redSocial.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity// definir la clase como una entidad
@Table(name="posts")//nombre de la tabla en la base  de 
@Data//getters y setters con lombuk
@Builder//permite usar el patron builder 
@NoArgsConstructor   //Constructor vacio
@AllArgsConstructor //constructor con todos los campos
public class Post {

    @Id //clave primaria de la tabla
    @GeneratedValue(strategy= GenerationType.IDENTITY)//la base de datos genera el id
    private Long id;

    @Column(name="contenido")
    private String contenido;

    @Column(name="imagen_url")
    private String imagenUrl;

    @Column(name="fecha_creacion",updatable=false)
    private LocalDateTime fechaCreacion;

    //con el opcional en falso define que siempre debe estar relaciona a un usuario o el equivalente a not null
    //con el fetchde tipo lazy se trae un proxi del usuario y solo es eccesible si se 
    //con el eager se tipo eager se trae toda la informacion del usuario directamente en la consulta
    @ManyToOne(optional=false,fetch=FetchType.LAZY)//relacion con la tabla usuario 
    @JoinColumn(name="usuario_id")//nombre del campo en la base de datos para hacer la relacion
    private Usuario usuario;
}
