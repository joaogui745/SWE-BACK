## TryFood - Sistema de Gerenciamento de Restaurantes

Este projeto Java tem como objetivo criar um sistema de gerenciamento de restaurantes, com funcionalidades que permitem o cadastro de usuários, restaurantes, pratos e avaliações. Para facilitar o desenvolvimento e organização, o projeto utiliza o Apache Ant como gerenciador de projetos, automatizando tarefas como compilação e execução.

O código-fonte está estruturado em pacotes que separam as diferentes responsabilidades do sistema. O pacote `bancodedados` contém as classes que gerenciam a interação com o banco de dados, incluindo scripts SQL para criação das tabelas. As entidades do sistema, como Usuário, Restaurante, Prato e Avaliação, são representadas pelas classes definidas no pacote `modelos`.  O pacote `permanencia`  contém interfaces e classes para acesso aos dados (DAO),  o que garante a separação da lógica de persistência da lógica de negócio. Por fim, o pacote `tryfood` contém a classe principal `TryFood.java`, responsável por iniciar a aplicação.

![image](https://github.com/user-attachments/assets/6da31d56-0304-4669-94eb-001f10e3a6e6)


Para executar o projeto, você precisa ter o Java Development Kit (JDK) e o Apache Ant instalados em seu sistema. Após baixar o código-fonte, navegue até o diretório raiz do projeto através do terminal ou prompt de comando. Utilize o comando `ant compile` para compilar o projeto e `ant run` para executá-lo.

A classe `TryFood.java`  inclui exemplos de como interagir com o sistema, demonstrando como cadastrar usuários, restaurantes e pratos, realizar avaliações e consultar os dados. O Apache Ant, por sua vez,  agiliza o processo de compilação e execução através do arquivo `build.xml`, que define tarefas como `compile`, `run` e `clean`.

Vale ressaltar que o sistema utiliza um banco de dados SQLite para armazenar os dados e que as classes DAO (Data Access Object) fornecem uma interface para acessar os dados. Essa estrutura permite que a implementação do banco de dados seja modificada sem afetar outras partes do sistema.
