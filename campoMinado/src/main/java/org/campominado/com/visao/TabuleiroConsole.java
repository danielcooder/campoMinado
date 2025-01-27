package org.campominado.com.visao;
import org.campominado.com.excecao.ExplosaoException;
import org.campominado.com.excecao.SairException;
import org.campominado.com.modelo.Tabuleiro;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {

                cicloDoJogo();

                System.out.println("Outra partida? (S/n");
                String resposta = entrada.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }

        } catch (SairException e) {
            System.out.println("Tchau!");
        } finally {
            entrada.close();
        }

    }

    private String cicloDoJogo() {
        try {
            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);

                String digitado = capturarValorDigitado("Digite (x , y): ");

                Iterator<Integer> xy = Arrays.stream(digitado.split(" , "))
                        .map(e -> Integer.parseInt(e.trim())).iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

                if("1".equals(digitado)){
                    tabuleiro.abrir(xy.next(), xy.next());
                } else if("2".equals(digitado)){
                    tabuleiro.alternarMarcacao(xy.next(), xy.next());
                }

            }

            System.out.println("Você ganhou!  ##PARABÉNS##");
        } catch (ExplosaoException e) {
            System.out.println("Você perdeu!");
            tabuleiro.reiniciar();
        }
        return null;
    }

    private String capturarValorDigitado(String texto) {
        System.out.println(texto);
        String digitado = entrada.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }

        return digitado;
    }
}

