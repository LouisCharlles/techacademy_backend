package techacademy.techacademy_backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/criar_usuario")
    public ResponseEntity<UserCreateResponse> registerNewUser(@RequestBody UserRequestPayload payload){
        return usuarioService.registerNewUser(payload);
    }

    @GetMapping("/info_usuario/{usuario_id}")
    public ResponseEntity<Usuario> getUserDetails(@PathVariable Integer usuario_id){
        return usuarioService.getUserDetails(usuario_id);
    }
}
