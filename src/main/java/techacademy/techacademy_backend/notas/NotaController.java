package techacademy.techacademy_backend.notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos-avaliar")
@CrossOrigin(origins = "*")
public class NotaController {

    @Autowired
    private NotaService notaService;


    @PostMapping("/avaliacoes")
    public Nota salvarNota(@RequestBody NotaRequestPayload payload) throws Exception {
        return notaService.salvarNota(payload.email(), payload.id_curso(), payload.nota());
    }
}
