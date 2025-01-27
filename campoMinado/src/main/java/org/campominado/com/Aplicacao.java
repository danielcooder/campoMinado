package org.campominado.com;

import org.campominado.com.modelo.Tabuleiro;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6 , 6, 6);

        tabuleiro.abrir(3, 3);
        tabuleiro.alternarMarcacao(4,4);


        System.out.println(tabuleiro);


    }

}
