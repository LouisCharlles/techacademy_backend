package techacademy.techacademy_backend.notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos-avaliar")
public class NotaController {

    @Autowired
    private NotaService notaService;


    @PostMapping("/avaliacoes")
    public Nota salvarNota(@RequestBody NotaRequestPayload payload) throws Exception {
        return notaService.salvarNota(payload.id_curso(), payload.id_usuario(), payload.nota());
    }
}
