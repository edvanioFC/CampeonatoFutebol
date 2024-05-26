package Campeonato;

import Enums.Cartao;
import Enums.Posicao;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JogadorTest {


    @InjectMocks
    Jogador jogador;
    @Test
    public void testExibirJogador() {
        String result = jogador.exibirJogador();
        String expected = " Nome: " + jogador.getNome() + " - (" + jogador.getApelido() + ")" +
                " Data de Nascimento: " + jogador.getDataNascimento()+
                " Número: " + jogador.getNumero() +
                " Posição: " + "Avancado_Centro" +
                " Qualidade: " + jogador.getQualidade() +
                "Condição: " + jogador.condicao();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testVerificaCondicaoJogo() {
        boolean result = jogador.verificaCondicaoJogo();
        Assertions.assertTrue(result);
    }

    @Test
    public void testAplicarCartao() {
        jogador.aplicarCartao(Cartao.AMARELO, 0);
    }

    @Test
    public void testCumprirSuspencao() {
        jogador.cumprirSuspencao();
    }

    @Test
    public void testSofrerLesao() {
        jogador.sofrerLesao();
    }

    @Test
    public void testExecutarTreinamento() {
        jogador.executarTreinamento();
    }

    @Test
    public void testCondicao() {
        String result = jogador.condicao();
        Assertions.assertEquals("TÁ PRA JOGO", result);
    }
}
