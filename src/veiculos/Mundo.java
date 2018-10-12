/*
 * To change this license header, choose License Headers in Project Properties.
 e file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolinacosta
 */
public class Mundo{
    
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    private static final Integer TAMANHO_X = 60;
    private static final Integer TAMANHO_Y = 30;
    
    private static String mundo = "";
    
    private static List<Veiculo> veiculos = new ArrayList<>(); 
            
    public static void main(String[] args){
        
        veiculos.addAll(criaVeiculos(Bicicleta.class));
        veiculos.addAll(criaVeiculos(Moto.class));
        veiculos.addAll(criaVeiculos(Carro.class));
        veiculos.addAll(criaVeiculos(Caminhao.class));
        
        while (true){
            for(int y = 0; y <= TAMANHO_Y; y++){
                for(int x = 0; x <= TAMANHO_X; x++){
                    String cor = verificaSeTemVeiculo(x, y);
                    mundo += cor + " ";
                    if (x == TAMANHO_X){
                        mundo += "/n";
                    }
                    
                }
            }
            System.out.print(mundo);
            mundo = "";
            
            moveTodosVeiculos(veiculos); //Se tiver na fabrica instancia um novo;
            veiculos = removeColididos();
           
        }
    }
    
    private static <T extends Veiculo> List<T> criaVeiculos(Class <T> clazz){
        
        List<T> criados = new ArrayList<>();
        
        for(int i = 0; i < 10; i++){
            try {
                T veiculo = clazz.newInstance();
                veiculo.setX((float) (int) (1 + Math.random() * (TAMANHO_X -1)));
                veiculo.setY((float) (int) (1 + Math.random() * (TAMANHO_Y -1)));
                
                criados.add(veiculo);
                           
            } catch (IllegalAccessException | InstantiationException ex) {
                Logger.getLogger(Mundo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return criados;
        
    }
    
    private static void moveTodosVeiculos(List<Veiculo> veiculos){
       veiculos.forEach(veiculo -> veiculo.move());
    }

    private static List<Veiculo> removeColididos() {
       List<Veiculo> sobreviventes = new ArrayList<>();
       atual : for(Veiculo veiculoAtual : veiculos){
        for(Veiculo veiculoComparar : veiculos){
           if(veiculoAtual.equals(veiculoComparar)){
               continue;
           } 
           if(veiculoAtual.isColisoes(veiculoComparar) && veiculoAtual.getPeso() <= veiculoComparar.getPeso()){
               continue atual;
           }
        }
        sobreviventes.add(veiculoAtual);
       }
       return sobreviventes;   
    }

    private static String verificaSeTemVeiculo(int x, int y) {
        for(Veiculo veiculo : veiculos){
            if(veiculo.getX().equals(x) && veiculo.getY().equals(y)){
               return veiculo.getCor();
            }
        }
        return x == TAMANHO_X || x == 0 || y == TAMANHO_Y || y == 0 ? ANSI_BLACK_BACKGROUND : ANSI_WHITE_BACKGROUND;
    }
        
}
