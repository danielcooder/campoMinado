package org.campominado.com;
import org.campominado.com.modelo.Tabuleiro;
import org.campominado.com.visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6 , 6, 5);

        new TabuleiroConsole(tabuleiro);

    }

}
