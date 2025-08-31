package com.redSocial.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.redSocial.dto.UsuarioDTO;
import com.redSocial.redSocial.services.UsuarioService;

@RestController// definir la clase como un controllador 
@RequestMapping("/usuarios") //ruta inicial para el controllador
public class UsuarioController {
    @Autowired // evita usar el constructor directamente
    private UsuarioService usuarioService;


    //emdoint para obtener los usuarios
    @GetMapping("")
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuarios(){
        //buscar los usuarios con el servicio        
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();

        //devolver un estado 200 con los usuarios
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);
    }
}
