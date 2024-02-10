package github.manu.crud.usuario.controller;

import github.manu.crud.usuario.dto.UsuarioDTO;
import github.manu.crud.usuario.model.Usuario;
import github.manu.crud.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class UsuarioController {
    @Autowired
    UsuarioService service;
    @GetMapping("buscarUsuarios")
    public List<Usuario> get(){
        return this.service.get();
    }
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO request) {
        String loginResult = service.post(request);
        return ResponseEntity.ok(loginResult);
    }
}
