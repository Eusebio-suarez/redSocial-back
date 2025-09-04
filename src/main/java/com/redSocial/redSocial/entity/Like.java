package com.redSocial.redSocial.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//definir la clase como una entiddad
@Table(name="likes")//nombre de la tabla en la base de datos
@Data//geters y setter con lombuk
@Builder//permite usar el patron builder 
@NoArgsConstructor   //Constructor vacio
@AllArgsConstructor //constructor con todos los campos
public class Like {
    @Id //clave primaria de la tabla
    @GeneratedValue( strategy=GenerationType.IDENTITY)//la base d edatos genera el id autoincrementable
    private Long id;

    @Column(name="fecha",updatable=false)
    private LocalDateTime fecha;
    //hacer la relacion con la tabla de usuario
    //cuando se desactiva el opcional se define que cada like debe estar relacionada con un usuario
    @ManyToOne(optional=false)
    Usuario usuario;
}
