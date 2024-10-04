package techacademy.techacademy_backend.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false)

    private String senha;

    public Usuario(UserRequestPayload payload){
        this.nome = payload.nome();
        this.email = payload.email();
        this.senha = payload.senha();
    }

}
