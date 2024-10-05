package techacademy.techacademy_backend.notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techacademy.techacademy_backend.curso.Curso;
import techacademy.techacademy_backend.curso.CursoRepository;
import techacademy.techacademy_backend.usuario.UserRepository;
import techacademy.techacademy_backend.usuario.Usuario;


import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private UserRepository userRepository;

    public Nota salvarNota(Integer id_usuario, Integer id_curso, Double nota) throws Exception {

        Optional<Curso> cursoOpt = cursoRepository.findById(id_curso);
        Optional<Usuario> usuarioOpt = userRepository.findById(id_usuario);

        if (cursoOpt.isEmpty()) {
            throw new Exception("Curso não encontrado com id: " + id_curso);
        }

        if (usuarioOpt.isEmpty()) {
            throw new Exception("Usuário não encontrado com id: " + id_usuario);
        }

        // Cria e salva a entidade de Nota
        Nota notaEntity = new Nota();
        notaEntity.setCurso(cursoOpt.get());
        notaEntity.setUsuario(usuarioOpt.get());
        notaEntity.setNota(nota);

        return notaRepository.save(notaEntity);
    }
}
