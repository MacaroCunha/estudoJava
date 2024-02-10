package github.manu.crud.usuario.service;

import github.manu.crud.usuario.dto.UsuarioDTO;
import github.manu.crud.usuario.model.Usuario;
import github.manu.crud.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;
    public List<Usuario> get(){
        return this.repository.findAll();
    }

    public String post(UsuarioDTO request){
       Usuario usuarioRecuperado = this.repository.findById(request.getId())
               .orElseThrow(() -> new RuntimeException("Error"));

       if(request.getPass().equals(usuarioRecuperado.getSenhaUsuario())){
           return "Login concedido";
       }else{
           return "problema ao fazer login";
       }
    }
}
