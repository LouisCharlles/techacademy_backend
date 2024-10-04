package techacademy.techacademy_backend.perguntas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techacademy.techacademy_backend.curso.Curso;

import java.util.List;
@Repository
public interface PerguntasRepository extends JpaRepository<Perguntas,Integer> {
    List<Perguntas> findByCurso(Curso curso);
}
