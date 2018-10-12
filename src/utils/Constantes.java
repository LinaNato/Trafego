/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author carolinacosta
 */
public class Constantes {
    public static enum CoresBackground{
        DEFAULT("\u001B[40m"), BRANCO("\u001B[47m"), VERMELHO("\u001B[41m"), AZUL("\u001B[44m"), VERDE("\u001B[42m"), AMARELO("\u001B[43m");
        
        private String cor;

        private CoresBackground(String cor) {
            this.cor = cor;
        }
        
        public String getCor(){
            return this.cor;
        }
    }
    
    public static final Integer TAMANHO_X = 60;
    public static final Integer TAMANHO_Y = 30;
}
