package bancodedados;

public class Dados {
    public static String usuarios = """
                               INSERT INTO usuario (nome, senha, email, documento, tipoDocumento)
                               VALUES
                                   ('John Doe', 'password123', 'john.doe@example.com', '12345678900', 'cpf'),
                                   ('Jane Smith', 'secret', 'jane.smith@example.com', '98765432100', 'cpf'),
                                   ('Company Inc.', 'company123', 'company@example.com', '12345678000123', 'cnpj'),
                                   ('David Lee', 'password456', 'david.lee@example.com', '09876543200', 'cpf');
                               """;
    public static String restaurantes = """
                                INSERT INTO restaurante (nome, descricao, temEntrega, localizacao, idUsuario) VALUES
                                ('Cezar''s', 'Italian Restaurant', 1, 'Downtown', 1), 
                                ('Sayonara', 'Sushi Place', 0, 'Uptown', 2),
                                ('Porcao', 'Burger Joint', 1, 'Midtown', 1),
                                ('Texmex', 'Taco Stand', 1, 'Downtown', 3),
                                ('Domino''s', 'Pizza Place', 0, 'Suburbs', 2);
                                """;
    public static String pratos = """
                                INSERT INTO prato (nome, descricao, preco, imagem, idRestaurante) VALUES
                                ('Pizza Margherita', 'Pizza clássica com molho de tomate, mussarela e manjericão.', 35.00, 'pizza_margherita.jpg', 1),
                                ('Lasanha à Bolonhesa', 'Tradicional lasanha com molho de carne moída e queijo.', 42.00, 'lasanha_bolonhesa.jpg', 1),
                                ('Strogonoff de Frango', 'Strogonoff cremoso com arroz branco.', 38.00, 'strogonoff_frango.jpg', 2),
                                ('Salmão Grelhado', 'Salmão grelhado com legumes salteados.', 55.00, 'salmao_grelhado.jpg', 2),
                                ('Hambúrguer Artesanal', 'Hambúrguer suculento com queijo cheddar e bacon.', 32.00, 'hamburguer_artesanal.jpg', 3),
                                ('Costelinha BBQ', 'Costelinha de porco assada com molho barbecue.', 48.00, 'costelinha_bbq.jpg', 3);
                            """;
    public static String avaliacao = """
                                     INSERT INTO avaliacao (nota, conteudo, idRestaurante, idUsuario)
                                     VALUES
                                         (4.5, 'Comida deliciosa, atendimento rápido!', 1, 1),
                                         (3.0, 'A comida estava ok, mas o ambiente poderia ser melhor.', 2, 2),
                                         (5.0, 'Melhor restaurante da cidade! Atendimento impecável.', 3, 1),
                                         (2.5, 'Demorou muito para servir, e a comida não estava tão boa.', 1, 3),
                                         (4.0, 'Lugar aconchegante, com ótimas opções vegetarianas.', 4, 2);
                                     """;
}
