


import org.example.Operacoes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.DivisaoPorZeroException;

class OperacoesTest {

    @Test
    void testSomar() {
        assertEquals(5.0, Operacoes.somar(2.0, 3.0));
        assertEquals(-1.0, Operacoes.somar(2.0, -3.0));
    }

    @Test
    void testSubtrair() {
        assertEquals(1.0, Operacoes.subtrair(3.0, 2.0));
        assertEquals(5.0, Operacoes.subtrair(2.0, -3.0));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6.0, Operacoes.multiplicar(2.0, 3.0));
        assertEquals(-6.0, Operacoes.multiplicar(2.0, -3.0));
    }

    @Test
    void testDividir() throws DivisaoPorZeroException {
        assertEquals(2.0, Operacoes.dividir(6.0, 3.0));
        assertEquals(-2.0, Operacoes.dividir(6.0, -3.0));
    }

    @Test
    void testDividirPorZero() {
        assertThrows(DivisaoPorZeroException.class, () -> {
            Operacoes.dividir(5.0, 0.0);
        });
    }
}
