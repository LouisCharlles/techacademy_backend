CREATE TABLE notas(id_nota int primary key AUTO_INCREMENT,
                   id_usuario int,
                   id_curso int,
                   nota decimal(3,1),
                   total_perguntas int,
                   perguntas_corretas int,
                   foreign key(id_usuario) references usuarios(usuario_id) ON DELETE CASCADE,
                   foreign key(id_curso) references cursos(id_curso) ON DELETE CASCADE
                   );