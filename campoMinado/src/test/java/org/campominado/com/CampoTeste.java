package org.campominado.com;

import org.campominado.com.excecao.ExplosaoException;
import org.campominado.com.modelo.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampoTeste {

    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    public void testeVizinhoDistancia1Esquerda() {
        Campo vizinhoEsquerda = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinhoEsquerda);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistancia1Direita() {
        Campo vizinhoDireita = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinhoDireita);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistancia1EmCima() {
        Campo vizinhoCima = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinho(vizinhoCima);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistancia1EmBaixo() {
        Campo vizinhoBaixo = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinhoBaixo);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistancia2() {
        Campo vizinhoDiagonal = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinhoDiagonal);
        assertTrue(resultado);
    }

    @Test
    public void testeNaoVizinho() {
        Campo naoVizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(naoVizinho);
        assertFalse(resultado);
    }

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAbrirMinadoMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> campo.abrir());
    }

    @Test
    void testeAbrirComVizinhos1() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2 , 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbrirComVizinhos2() {
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 1);
        campo12.minar();

        Campo campo22 = new Campo(2 , 3);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }

}
