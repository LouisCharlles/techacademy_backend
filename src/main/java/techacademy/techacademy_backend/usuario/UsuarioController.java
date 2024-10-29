package techacademy.techacademy_backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginPayload payload) {
        return usuarioService.login(payload);
    }

    @GetMapping("/profile")
    public ResponseEntity<Usuario> getProfile(@RequestHeader(value = "Authorization", required = false) String token) {

        System.out.println(token.substring(7));

        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(401).build();
        }


        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return usuarioService.getProfile(token);
    }
}
