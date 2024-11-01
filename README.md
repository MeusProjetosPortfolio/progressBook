# API de Incentivo à Leitura 📚

## Descrição
Este projeto é uma API para motivar e acompanhar o progresso de leitura dos usuários. Com funcionalidades que permitem o cadastro de usuários, conquistas, livros, progresso, e leituras, a API possibilita que os usuários estabeleçam metas de leitura, registrem suas conquistas e acompanhem o tempo e o percentual de conclusão de cada livro. À medida que os usuários completam livros, suas conquistas são desbloqueadas.

O sistema foi desenvolvido utilizando **Java** e **Spring Boot**, com o banco de dados **PostgreSQL** e o **Flyway** para gerenciamento de migrações. A documentação de todas as rotas da API está disponível via **Swagger**.

## Tecnologias Utilizadas no Backend
- <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
- <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
- <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
- <img src="https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white" />
- <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />

## Funcionalidades
1. **Cadastro de Usuários**: Registro do usuário com informações como nome, e-mail, foto, e nível de leitura.
2. **Cadastro de Conquistas**: Os usuários definem suas próprias conquistas e recebem pontos ao completá-las.
3. **Cadastro de Livros**: Permite registrar informações sobre o livro, como título, autor, gênero, e número de páginas.
4. **Registro de Progresso**: Acompanhamento do status de leitura (lendo, concluído, etc.), data de início e término, e notas de progresso.
5. **Registro de Leitura**: Os usuários podem avaliar os livros, registrar a página atual e observar o percentual de progresso.

## Estrutura dos Dados

**Usuário**
```json
{
    "name": "John Doe",
    "email": "jonny@gmail.com",
    "photo": "url:teste",
    "readerLevel": "Intermediate"
}
```

**Conquista**
```json
{
    "name": "First Book Finished",
    "description": "Complete your first book",
    "points": 1,
    "imgArchievement": "teste"
}
```

**Livro**
```json
{
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "genre": "Programming",
    "totalPages": 300
}
```

**Progresso**
```json
{
    "status": "Reading",
    "startDate": "2024-01-01",
    "endDate": "2024-02-01",
    "progressNote": "Livro está interessante até o momento"
}
```

**Leitura**
```json
{
    "rating": 4,
    "currentPage": 300,
    "user": { "id": 1 },
    "book": { "id": 1 },
    "progress": { "id": 1 }
}
```

## Requisitos
- **Java 21** instalado.
- **PostgreSQL** configurado.
- **Maven** para gerenciamento de dependências.

## Documentação da API
A documentação das rotas pode ser acessada via Swagger. Basta iniciar o projeto e acessar `http://localhost:8080/swagger-ui.html` para visualizar todas as rotas disponíveis e testá-las diretamente.

## Configuração do Banco de Dados
A API utiliza o Flyway para gerenciar as migrações do banco de dados. Ao iniciar a aplicação, o Flyway executará automaticamente as migrações para criar e atualizar as tabelas necessárias.

## Instruções para Uso
1. Clone o repositório e faça a configuração do banco de dados no arquivo `application.properties`.
2. Compile e inicie o projeto usando Maven: `mvn spring-boot:run`.
3. Acesse o Swagger para interagir com a API.

## Futuras Melhorias
- Implementação de notificação de email parabenizando ao atingir uma conquista.
- Frontend da API.
- Filtro com o ranking de leitura com base nas notas. 

## Autor
João Vitor Costa Rolim

## Repositório
https://github.com/MeusProjetosPortfolio/progressBook

## Contribuição
Contribuições são bem-vindas! Fique à vontade para enviar PRs com melhorias, correções de bugs ou novas funcionalidades.

