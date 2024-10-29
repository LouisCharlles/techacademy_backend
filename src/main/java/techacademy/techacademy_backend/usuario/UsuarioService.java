package techacademy.techacademy_backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JWTUtils jwtUtils = new JWTUtils();

    public ResponseEntity<UserCreateResponse> registerNewUser(UserRequestPayload payload){
        String hashedPassword = passwordEncoder.encode(payload.senha());
        Usuario usuario = new Usuario(payload);
        usuario.setSenha(hashedPassword);

        this.userRepository.save(usuario);
        return ResponseEntity.ok(new UserCreateResponse(usuario));
    }

    public ResponseEntity<Usuario> getUserDetails(Integer usuario_id){
        Optional<Usuario> usuario = this.userRepository.findById(usuario_id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<LoginResponse> login(UserLoginPayload payload) {
        Optional<Usuario> usuarioOpt = userRepository.findByEmail(payload.email());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            if (passwordEncoder.matches(payload.senha(), usuario.getSenha())) {
                String token = JWTUtils.generateToken(usuario);

                return ResponseEntity.ok(new LoginResponse(token));
            }
        }

        return ResponseEntity.status(401).build();
    }

    public ResponseEntity<Usuario> getProfile(String token) {
        if (token != null && !token.isEmpty() && !jwtUtils.isTokenExpired(token)) {
            String email = jwtUtils.extractEmail(token);

            Optional<Usuario> usuarioOpt = userRepository.findByEmail(email);

            return usuarioOpt.map(usuario -> ResponseEntity.ok(usuario.withoutPassword()))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        return ResponseEntity.status(401).build();
    }
}

