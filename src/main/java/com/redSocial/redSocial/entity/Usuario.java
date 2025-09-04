package com.redSocial.redSocial.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//definir la colase como una entidad
@Data//geters y setters con lombuk
@Table(name="usuarios")//nombre de la tabla en la base de datos
@Builder//permite usar el patron builder 
@NoArgsConstructor   //Constructor vacio
@AllArgsConstructor //constructor con todos los campos
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

    //relacion de muchos a uno con la tabla de posts
    //Ese "usuario" es el nombre exacto del atributo que debe tener la clase Post
    //si se hace una modificacion con el usuario el los ports tambien dse modificaran si se elimina el usuario los posts tambien
    @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
    //lsita de posts
    List<Post> posts;

    //hacer la relacion con al entidad de likes
    //el mappedBy especifica el campo que debe tener la tabla entidad de likes
    @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
    //likes del usuario
    List<Like> likes;

    //se evitita que se actualize la fecha cuando se cambia ekl registro
    @Column(name = "fecha_creacion", updatable=false)
    private LocalDateTime fechaCreacion;

}
