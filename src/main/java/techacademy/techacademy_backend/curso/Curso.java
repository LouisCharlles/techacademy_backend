package techacademy.techacademy_backend.curso;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techacademy.techacademy_backend.perguntas.Pergunta;


import java.util.List;

@Getter
@Setter
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_curso;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(name = "video_link", nullable = false)
    private String videoLink;

    @OneToMany(mappedBy = "perguntasCurso",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pergunta> perguntas;

    @JoinColumn(name = "id_perguntas",foreignKey = @ForeignKey(name = "fk_pergunta"))
    private Integer id_perguntas;

    public Curso(CursoRequestPayload data){
        this.title = data.title();
        this.description = data.description();
        this.videoLink = data.video_link();
        this.perguntas = data.perguntas();
    }

}
