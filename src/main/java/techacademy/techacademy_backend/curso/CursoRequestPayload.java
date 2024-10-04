package techacademy.techacademy_backend.curso;

import techacademy.techacademy_backend.perguntas.Perguntas;

import java.util.List;

public record CursoRequestPayload(String title, String description, String video_link, List<Perguntas> perguntas){
}
