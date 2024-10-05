package techacademy.techacademy_backend.perguntas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import techacademy.techacademy_backend.curso.Curso;



@Entity
@Table(name = "perguntas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_perguntas;

    @Column(name = "perguntas_curso",nullable = false)
    private String perguntasCurso;
    @Column(name = "opcao_a")
    private String opcaoA;
    @Column(name = "opcao_b")
    private String opcaoB;
    @Column(name = "opcao_c")
    private String opcaoC;
    @Column(name = "opcao_d")
    private  String opcaoD;
    @Column(name = "resposta_correta",nullable = false)
    private String respostaCorreta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso",nullable = false)
    @JsonBackReference
    private Curso curso;




}
