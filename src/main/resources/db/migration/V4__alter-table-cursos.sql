ALTER TABLE cursos
ADD COLUMN id_perguntas INTEGER,
ADD CONSTRAINT fk_id_perguntas FOREIGN KEY(id_perguntas) references perguntas(id_perguntas);