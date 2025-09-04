package com.redSocial.redSocial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.redSocial.dto.PostResponseDTO;
import com.redSocial.redSocial.services.PostService;

@RestController//dafinar la clase cpmom un controllador
@RequestMapping("/posts")//definir la ruta inicial del controllador
public class PostController {
    
    @Autowired//evita usra el contructor directamente
    PostService postService;

    //endpoint para obtener las publiccaciones
    @GetMapping("")
    public ResponseEntity<List<PostResponseDTO>> obtenerPublicaciones(){
        //obtener las publicaciones con el service
        List<PostResponseDTO> publicaciones = postService.obtenerPublicaciones();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(publicaciones);
    }
}
