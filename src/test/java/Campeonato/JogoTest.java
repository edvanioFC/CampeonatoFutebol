package Campeonato;

import Enums.Posicao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JogoTest {
    @Mock
    Equipa mandante;
    @Mock
    Equipa visitante;
    @Mock


    @InjectMocks
    Jogo jogo;

    @Test
    public void testGerarResultado() {
        when(mandante.relacionarMelhoresJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(visitante.relacionarMelhoresJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));

        jogo.gerarResultado();
    }

    @Test
    public void testGerarCartoes() {
        when(mandante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(mandante.getRelacionados()).thenReturn(new ArrayList<>(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0))));
        when(visitante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(visitante.getNome()).thenReturn("getNomeResponse");
        when(visitante.getRelacionados()).thenReturn(new ArrayList<>(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0))));

        jogo.gerarCartoes();
        verify(mandante).setJogadoresSuspensos(any(Jogador.class));
        verify(visitante).setJogadoresSuspensos(any(Jogador.class));
    }

    @Test
    public void testAplicarCartoes() {
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(mandante.getRelacionados()).thenReturn(new ArrayList<>(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0))));
        when(visitante.getNome()).thenReturn("getNomeResponse");
        when(visitante.getRelacionados()).thenReturn(new ArrayList<>(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0))));

        jogo.aplicarCartoes(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)), 0, new Equipa("nome", "apelido", 0, new ArrayList<>(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)))));
        verify(mandante).setJogadoresSuspensos(any(Jogador.class));
        verify(visitante).setJogadoresSuspensos(any(Jogador.class));
    }

    @Test
    public void testGerarLesao() {
        when(mandante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(visitante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(visitante.getNome()).thenReturn("getNomeResponse");

        jogo.gerarLesao();
    }

    @Test
    public void testSubstituirJogador() {
        when(mandante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", null, null, 0, null, 0)));
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(visitante.relacionarJogadores()).thenReturn(List.of(new Jogador(0, "nome", null, null, 0, null, 0)));
        when(visitante.getNome()).thenReturn("getNomeResponse");

        jogo.substituirJogador(new Jogador(0, "nome", null, null, 0, null, 0), new Jogador(0, "nome", null, null, 0, null, 0), new Equipa("nome", "apelido", 0, new ArrayList<>(List.of(new Jogador(0, "nome", null, null, 0, null, 0)))));
    }

    @Test
    public void testExibirResultado() throws InterruptedException {
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(visitante.getNome()).thenReturn("getNomeResponse");

        jogo.exibirResultado();
    }

    @Test
    public void testPermitirTreinamento() {
        when(mandante.relacionarMelhoresJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));
        when(visitante.relacionarMelhoresJogadores()).thenReturn(List.of(new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0)));

        jogo.permitirTreinamento();
    }

    @Test
    public void testDadosJogo() {
        when(mandante.getNome()).thenReturn("getNomeResponse");
        when(visitante.getNome()).thenReturn("getNomeResponse");

        jogo.dadosJogo();
    }
}

