/*
 * To change this license header, choose License Headers in Project Properties.
 e file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constantes;

/**
 *
 * @author carolinacosta
 */
public class Mundo{
    
    private static String mundo = "";
    
    private static List<Veiculo> veiculos = new ArrayList<>(); 
            
    public static void main(String[] args){
        
        veiculos.addAll(criaVeiculos(Bicicleta.class));
        veiculos.addAll(criaVeiculos(Moto.class));
        veiculos.addAll(criaVeiculos(Carro.class));
        veiculos.addAll(criaVeiculos(Caminhao.class));
        
        while (true){
            for(int y = 1; y <= Constantes.TAMANHO_Y; y++){
                for(int x = 1; x <= Constantes.TAMANHO_X; x++){
                    String cor = verificaSeTemVeiculo(x, y);
                    mundo += cor + " ";
                    if (x == Constantes.TAMANHO_X){
                        mundo += System.lineSeparator();
                    }
                }
            }
            System.out.print("SITUAÇÃO VEICULOS:");
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
                veiculo.setX((float) (int) (1 + Math.random() * (Constantes.TAMANHO_X -1)));
                veiculo.setY((float) (int) (1 + Math.random() * (Constantes.TAMANHO_Y -1)));
                
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

    private static String verificaSeTemVeiculo(Integer x, Integer y) {
        for(Veiculo veiculo : veiculos){
            if(veiculo.isMesmaPosicao(x, y)){
                return veiculo.getCor();
            }
        }
        return (Objects.equals(x, Constantes.TAMANHO_X) || x == 0 
                || Objects.equals(y, Constantes.TAMANHO_Y) || y == 0 
                    ? Constantes.CoresBackground.DEFAULT 
                    : Constantes.CoresBackground.BRANCO).getCor();
    }
        
}
