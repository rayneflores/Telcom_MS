package com.ryfsystems.Telcom.controllers;

import com.ryfsystems.Telcom.entity.models.Usuario;
import com.ryfsystems.Telcom.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/")
    public Map<String,List<Usuario>> getAllUsuarios() {
        Map<String,List<Usuario>> response = new HashMap<>();
        List<Usuario> usuariosList;
        usuariosList = StreamSupport
                .stream(usuarioService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        response.put("usuarios", usuariosList);
        return response;
    }

    @GetMapping("/byZona/{zona}")
    public Map<String, List<Usuario>> getUsuariosByZona(String zona) {
        Map<String,List<Usuario>> response = new HashMap<>();
        List<Usuario> usuariosList;
        usuariosList = StreamSupport
                .stream(usuarioService.getByZonaUsuarios(zona).spliterator(), false)
                .collect(Collectors.toList());
        response.put("usuarios", usuariosList);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        Optional<Usuario> optionalUsuario = usuarioService.get(id);
        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalUsuario);
    }

    @GetMapping("/login/{cedula}/{codigo}")
    public ResponseEntity login(@PathVariable(value = "cedula") String cedula,
                                @PathVariable(value = "codigo") String codigo) {
        Optional<Usuario> optUsuario = usuarioService.getByCedulaAndPassActivos(cedula, codigo, "ACTIVO");
        if (!optUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Combinacion Cedula / Password Incorrecta!!!");
        }
        Usuario usuario = optUsuario.get();
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}