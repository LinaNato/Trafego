
package utils;

/**
 *
 * @author carolinacosta
 */
public class Constantes {
    public static enum CoresBackground{
        DEFAULT("\u001B[40m"),
        VERMELHO("\u001B[41m"), 
        VERDE("\u001B[42m"), 
        AMARELO("\u001B[43m"),
        AZUL("\u001B[44m"), 
        ROXO("\u001B[45m"),
        BRANCO("\u001B[47m");
        
        private String cor;

        private CoresBackground(String cor) {
            this.cor = cor;
        }
        
        public String getCor(){
            return this.cor;
        }
    }
    
    public static enum Cores{
        DEFAULT("\u001B[0m"),
        VERMELHO("\u001B[31m"), 
        VERDE("\u001B[32m"), 
        AMARELO("\u001B[33m"),
        AZUL("\u001B[34m"), 
        ROXO("\u001B[35m"),
        BRANCO("\u001B[37m");
        
        private String cor;

        private Cores(String cor) {
            this.cor = cor;
        }
        
        public String getCor(){
            return this.cor;
        }
    }
    
    public static final Integer TAMANHO_X = 60;
    public static final Integer TAMANHO_Y = 30;
}
