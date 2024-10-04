CREATE TABLE perguntas(id_perguntas INTEGER PRIMARY KEY AUTO_INCREMENT,
                        perguntas_curso TEXT NOT NULL,
                        id_curso INTEGER,
                        FOREIGN KEY(id_curso) REFERENCES  cursos(id_curso) ON DELETE CASCADE);