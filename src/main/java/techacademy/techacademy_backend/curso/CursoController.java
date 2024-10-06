package techacademy.techacademy_backend.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private  CursoService cursoService;

    @GetMapping("/{curso_id}")
    public ResponseEntity<Curso> getCursoDetails(@PathVariable("curso_id") Integer cursoId){
        return cursoService.getCursoDetails(cursoId);
    }
}
