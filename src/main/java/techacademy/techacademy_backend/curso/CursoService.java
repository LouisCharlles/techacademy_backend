package techacademy.techacademy_backend.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import techacademy.techacademy_backend.perguntas.Pergunta;
import techacademy.techacademy_backend.perguntas.PerguntasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private PerguntasRepository perguntasRepository;

    public ResponseEntity<Curso> getCursoDetails(Integer curso_id) {
        Optional<Curso> curso = this.cursoRepository.findById(curso_id);

        if(curso.isPresent()){
            Curso curso_extraido = curso.get();
            List<Pergunta> perguntas = perguntasRepository.findByCurso(curso_extraido);
            curso_extraido.setPerguntas(perguntas);
        }
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
