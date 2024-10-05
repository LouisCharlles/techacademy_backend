package techacademy.techacademy_backend.notas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techacademy.techacademy_backend.curso.Curso;
import techacademy.techacademy_backend.usuario.Usuario;

@Entity
@Table(name = "notas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer idNota;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name = "id_usuario"))
    @JsonBackReference
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_curso",foreignKey = @ForeignKey(name = "id_curso"))
    @JsonBackReference
    private Curso curso;

    private double nota;

}
