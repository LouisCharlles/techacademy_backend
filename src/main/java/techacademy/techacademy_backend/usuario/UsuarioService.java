package techacademy.techacademy_backend.usuario;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserCreateResponse> registerNewUser(UserRequestPayload payload){
        Usuario usuario = new Usuario(payload);

        this.userRepository.save(usuario);

        return ResponseEntity.ok(new UserCreateResponse(usuario));

    }

    public ResponseEntity<Usuario> getUserDetails(Integer usuario_id){
        Optional<Usuario> usuario = this.userRepository.findById(usuario_id);
        return usuario.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }
}
