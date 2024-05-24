# Projeto de Simulação de Campeonato de Futebol

Este projeto tem como objetivo simular a gestão de um campeonato de futebol, aplicando conceitos de Programação Orientada a Objetos (OOP), Collections, Stream, Optional e Enums.

## Classes

O projeto é composto pelas seguintes classes:

- `Jogador`: Representa um jogador de futebol, com atributos como id, nome, apelido, data de nascimento, número, posição, qualidade, cartões e se está suspenso ou não. A classe também possui métodos para verificar a condição de jogo do jogador, aplicar cartões, cumprir suspensão, sofrer lesão e executar treinamento.

- `Equipa`: Representa uma equipe de futebol, com atributos como nome, apelido, ano de fundação, plantel (lista de jogadores) e relacionados (lista de jogadores relacionados para um jogo). A classe também possui métodos para relacionar jogadores (selecionar os 18 jogadores, 11 titulares e 7 reservas, com base na qualidade e posição) e imprimir a escalação da equipe.

- `Jogo`: Representa um jogo de futebol, com atributos como as equipes mandante e visitante, data do jogo, estádio, cidade, placar do mandante e placar do visitante. A classe também possui métodos para gerar o resultado do jogo, gerar lesões, gerar cartões e permitir treinamento.

# Temos também 3 enums pra representar estados e posicões
- `Posicao`: Representa as 11 posições dos jogadores em um campo de futebol
- `Supenso`: Representa o estado de um jogador (suspenso ou disponível pra jogo)
- `Treinou` : Representa o estado do jogador (Treinou antes do jogo ou não)

# E algumas classes utils
- `DataUtil`: Gerador de data
- `GeradorNome`: Gera nome e apelidos aleatórios
- `VerificaInput`: Valida o tipo de dados

## Como usar

Para usar este projeto, você deve instanciar as classes `Jogador`, `Equipa` e `Jogo` e usar seus métodos para simular a gestão de um campeonato de futebol.

Por exemplo, você pode criar jogadores usando o construtor da classe `Jogador`, adicionar esses jogadores a uma equipe usando o métodos da classe `Equipa`, e então criar um jogo usando o construtor da classe `Jogo`.

Depois de criar um jogo, você pode usar os métodos `gerarResultado()`, `gerarLesoes()`, `gerarCartoes()` e `permitirTreinamento()` para simular o resultado do jogo, gerar lesões e cartões, e permitir que os jogadores treinem, respectivamente.

## Contribuição

Contribuições para este projeto são bem-vindas. Se você encontrar um bug ou tem uma sugestão de melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto é licenciado sob os termos da licença MIT. Leia  aqui <a href="https://github.com/edvanioFC/CampeonatoFutebol/blob/master/LICENSE" target="blanck">License</a>
