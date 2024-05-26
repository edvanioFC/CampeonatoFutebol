package org.example;

import Campeonato.*;
import org.mockito.Mock;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Ig11CampGestTest {
    @Mock
    Jogo jogo;
    @InjectMocks
    Ig11CampGest ig11CampGest;

    @Test
    public void testOpcoes() throws InterruptedException {

        verify(new Jogo(any(Equipa.class), any(Equipa.class), any(LocalDate.class), anyString(), anyString()));
        Ig11CampGest.opcoes();
        verify(jogo).gerarResultado();
        verify(jogo).gerarCartoes();
        verify(jogo).gerarLesao();
        verify(jogo).exibirResultado();
        verify(jogo).permitirTreinamento();
        verify(jogo).dadosJogo();
    }

    @Test
    public void testInstrucao() {
        Ig11CampGest.instrucao();
    }

    @Test
    public void testMenu() {
        Ig11CampGest.menu();
    }

    @Test
    public void testAplicarCartao() {
        Ig11CampGest.aplicarCartao();
    }

    @Test
    public void testAplicarCartaoJogador() {
        Ig11CampGest.aplicarCartaoJogador(new Equipa("nome", "apelido", 0, new ArrayList<>(List.of((Jogador) null))), 0);
    }

    @Test
    public void testAplicarSuspensao() {
        Ig11CampGest.aplicarSuspensao();
    }

    @Test
    public void testCumpritSuspensao() {
        Ig11CampGest.cumpritSuspensao();
    }

    @Test
    public void testExibirEquipas() {
        Ig11CampGest.exibirEquipas();
    }

    @Test
    public void testGetValidarEquipa() {
        int result = Ig11CampGest.getValidarEquipa();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testExibirJogadores() {
        Ig11CampGest.exibirJogadores(new Equipa("nome", "apelido", 0, new ArrayList<>(List.of(null))));
    }

    @Test
    public void testGetValidJogador() {
        int result = Ig11CampGest.getValidJogador(new Equipa(null, null, 0, new ArrayList<>(List.of(null))));
        Assert.assertEquals(0, result);
    }

    @Test
    public void testSuspenderJogador() {
        Ig11CampGest.suspenderJogador(new Equipa("nome", "apelido", 0, new ArrayList<>(List.of(null))), 0);
    }

    @Test
    public void testPermitirTreinamento() {
        Ig11CampGest.permitirTreinamento();
        verify(jogo).permitirTreinamento();
    }

    @Test
    public void testCriarEquipa() {
        Ig11CampGest.criarEquipa();
    }

    @Test
    public void testCadastrarJogador() {
        Ig11CampGest.cadastrarJogador();
    }

    @Test
    public void testPadrao() {
        Ig11CampGest.padrao();
    }

    @Test
    public void testImprimirEscalacao() {
        Ig11CampGest.imprimirEscalacao();
    }

    @Test
    public void testImprimirPlanteis() {
        Ig11CampGest.imprimirPlanteis();
    }

    @Test
    public void testSimularJogo() throws InterruptedException {
        Ig11CampGest.simularJogo();
        verify(new Jogo(any(Equipa.class), any(Equipa.class), any(LocalDate.class), anyString(), anyString()));
        verify(jogo).gerarResultado();
        verify(jogo).gerarCartoes();
        verify(jogo).gerarLesao();
        verify(jogo).exibirResultado();
        verify(jogo).dadosJogo();
    }

    @Test
    public void testIsFlag() {
        Boolean result = Ig11CampGest.isFlag();
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testGetScanner() {
        AutoCloseable result = ig11CampGest.getScanner();
        Assert.assertNull(result);
    }
}
