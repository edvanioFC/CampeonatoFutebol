package Campeonato;

import Enums.Posicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquipaTest {

    @Mock
    ArrayList<Jogador> plantel;
    @Mock
    ArrayList<Jogador> relacionados;
    @Mock
    ArrayList<Jogador> jogadoresSuspensos;
    @InjectMocks
    Equipa equipa;

    @BeforeEach
    public void setUp() {
        equipa = new Equipa();
        equipa.plantel = plantel;
        equipa.relacionados = relacionados;
        equipa.jogadoresSuspensos = jogadoresSuspensos;
    }

    @Test
    public void testRelacionarJogadores() throws Exception {
        when(plantel.stream()).thenReturn(Stream.empty());
        when(relacionados.stream()).thenReturn(Stream.empty());
        when(jogadoresSuspensos.stream()).thenReturn(Stream.empty());

        List<Jogador> result = equipa.relacionarJogadores();
        assertTrue(result.isEmpty());

        verify(plantel).stream();
        verify(relacionados).stream();
        verify(jogadoresSuspensos).stream();
    }

    @Test
    public void testRelacionarMelhoresJogadores() throws Exception {
        when(plantel.stream()).thenReturn(Stream.empty());
        when(relacionados.stream()).thenReturn(Stream.empty());
        when(jogadoresSuspensos.stream()).thenReturn(Stream.empty());

        List<Jogador> result = equipa.relacionarMelhoresJogadores();
        assertTrue(result.isEmpty());

        verify(plantel).stream();
        verify(relacionados).stream();
        verify(jogadoresSuspensos).stream();
    }

    @Test
    public void testAdicionarJogador() throws Exception {
        Jogador jogador = new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0);
        when(plantel.add(any(Jogador.class))).thenReturn(true);
        when(relacionados.add(any(Jogador.class))).thenReturn(true);
        when(jogadoresSuspensos.add(any(Jogador.class))).thenReturn(true);

        equipa.adicionarJogador(jogador);
        verify(plantel).add(jogador);
    }

    @Test
    public void testImprimirPlantel() throws Exception {
        equipa.imprimirPlantel();
        verify(plantel).forEach(any());
    }

    @Test
    public void testImprimirEscalacao() throws Exception {
        when(plantel.subList(anyInt(), anyInt())).thenReturn(List.of(new Jogador(0, "nome", "apelido", null, 0, Posicao.GOLEIRO, 0)));

        equipa.imprimirEscalacao();
        verify(plantel).forEach(any());
    }

    @Test
    public void testSetJogadoresSuspensos() throws Exception {
        Jogador jogador = new Jogador(0, "nome", "apelido", LocalDate.of(2024, Month.MAY, 25), 0, Posicao.GOLEIRO, 0);
        when(jogadoresSuspensos.add(any(Jogador.class))).thenReturn(true);

        equipa.setJogadoresSuspensos(jogador);
        verify(jogadoresSuspensos).add(jogador);
    }
}
