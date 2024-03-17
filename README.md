## Scripts para criar as tabelas no banco:
```
CREATE TABLE tutor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE
);

CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    datanascimento Date,
    nome VARCHAR(20) NOT NULL,
    personalidade VARCHAR(50) NOT NULL,
    especie VARCHAR(20) NOT NULL,
    raca VARCHAR(20)
);

CREATE TABLE adocao (
    id SERIAL PRIMARY KEY,
    idTutor INT NOT NULL,
    idAnimal INT NOT NULL,
    data Date NOT NULL,
    motivo VARCHAR(100) NOT NULL,
    FOREIGN KEY (idTutor) REFERENCES tutor(id),
    FOREIGN KEY (idAnimal) REFERENCES animal(id)
);

```
Se a tabela já estiver criada, faça o seguinte:
```
ALTER TABLE adocao DROP data;
ALTER TABLE adocao ADD data Date;
```
## Mapeamento lógico das tabelas:
Tutor(Id, Nome, Telefone, Endereco, Cpf)
Animal(Id, Idade, Nome, Personalidade, Especie, Raca)
Adocao(Id, IdTutor, IdAnimal, Data, Motivo)