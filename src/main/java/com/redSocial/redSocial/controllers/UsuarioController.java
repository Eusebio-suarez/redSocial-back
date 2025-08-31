package com.redSocial.redSocial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.redSocial.dto.UsuarioRequestDTO;
import com.redSocial.redSocial.dto.UsuarioResponseDTO;
import com.redSocial.redSocial.services.UsuarioService;

@RestController// definir la clase como un controllador 
@RequestMapping("/users") //ruta inicial para el controllador
public class UsuarioController {
    @Autowired // evita usar el constructor directamente
    private UsuarioService usuarioService;

    //endoint para obtener los usuarios
    @GetMapping("")
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios(){
        //buscar los usuarios con el servicio        
        List<UsuarioResponseDTO> usuarios = usuarioService.obtenerUsuarios();

        //devolver un estado 200 con los usuarios
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);
    }

    //enpoint para registar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> registarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDto){
        //registar el usuario desde el servicio
        UsuarioResponseDTO usuarioRegistrado = usuarioService.registarUsuario(usuarioRequestDto);

        //devolver un estado de crado 201 con la info del usuario
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRegistrado);
    }

}

