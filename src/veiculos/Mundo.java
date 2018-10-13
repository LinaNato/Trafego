
package veiculos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Constantes.Cores.AMARELO;
import static utils.Constantes.Cores.AZUL;
import static utils.Constantes.Cores.VERDE;
import static utils.Constantes.Cores.VERMELHO;
import static utils.Constantes.CoresBackground.BRANCO;
import static utils.Constantes.CoresBackground.DEFAULT;
import static utils.Constantes.TAMANHO_X;
import static utils.Constantes.TAMANHO_Y;

/**
 *
 * @author carolinacosta
 */
public class Mundo{
    
    
    /*
    Adiciona os veículos para a array.
    */
    private static String mundo = "";
    
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Fabrica> fabricas = new ArrayList<>();
            
    public static void main(String[] args){
        
        for(int i = 0; i < 10; i++){
            veiculos.add(criaVeiculo(Bicicleta.class));
            veiculos.add(criaVeiculo(Moto.class));
            veiculos.add(criaVeiculo(Carro.class));
            veiculos.add(criaVeiculo(Caminhao.class));
        }
        
        //Se precisar de mais de uma fabrica, criar aqui um for igual do veículo
        fabricas.add(criaFabrica()); // Só tem uma, mas se precisar de mais, ja está preparado

        while (true){
            for(int y = 1; y <= TAMANHO_Y; y++){
                for(int x = 1; x <= TAMANHO_X; x++){
                    String cor = verificaSeTemElemento(x, y);
                    mundo += cor + " ";
                    if (x == TAMANHO_X){
                        mundo += System.lineSeparator();
                    }
                }
            }
            
            /*
            Imprime "Score"dos veículos.
            */
            System.out.println("SITUAÇÃO VEICULOS: " + getScore());
            System.out.print(mundo);
            mundo = "";
            
            /*
            Move todos os veiculos e chama o método que remove os veiculos do array
            */
            moveTodosVeiculos(); //Se tiver na fabrica instancia um novo;
            removeColididos();
            criaNovosVeiculos();
                       
        }
    }
    
    /*
    Crio a Classe genérica T e instância novo array 
    O mapa se iniciará com 10 veículos de cada tipo em posições randômicas.
    */
    private static <T extends Veiculo> T criaVeiculo(Class <T> clazz){
        
        try {
            T veiculo = clazz.newInstance();
              
            //TODO - Fazer se der tempo: Esse random poderia ser passado para o construtor dos veículos
            veiculo.setX((float) (int) (1 + Math.random() * (TAMANHO_X -1)));
            veiculo.setY((float) (int) (1 + Math.random() * (TAMANHO_Y -1)));

            return veiculo;

        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(Mundo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private static Fabrica criaFabrica() {
        
        Fabrica fabrica = new Fabrica();
        
        //Fabrica Fixa no meio da tela
        fabrica.setX(new Float(TAMANHO_X / 2 + fabrica.getLargura() /2));
        fabrica.setY(new Float(TAMANHO_Y / 2 + fabrica.getAltura() /2));
        
        return fabrica;
    }

    
    private static void moveTodosVeiculos(){
       veiculos.forEach(veiculo -> veiculo.move());
    }

    /*
    Chama o metodo para remover os veiculos colididos e faz a comparação entre eles, Instanciando a Array "sobreviventes".
    Primeiramente compara com o próprio objeto para que ele não seja removido por ele mesmo
    Após, compara com outros veículos
    Para removido do Array de acordo com o peso de cada veículo.
    Sendo Bicicleta peso 1; Moto peso 2; Carro peso 3; Caminhao peso 4. Retornando aqueles que sobrevivem a colisão
    */
    private static void removeColididos() {
       List<Veiculo> sobreviventes = new ArrayList<>();
       atual : for(Veiculo veiculoAtual : veiculos){
        for(Veiculo veiculoComparar : veiculos){
           if(veiculoAtual.equals(veiculoComparar)){
               continue;
           } 
           if(veiculoAtual.isMesmaPosicao(veiculoComparar) && veiculoAtual.getPeso() <= veiculoComparar.getPeso()){
               continue atual;
           }
        }
        sobreviventes.add(veiculoAtual);
       }
       veiculos = sobreviventes;   
    }

    /*
    Verifica se na coordenada XY existe um elemento e devolve a cor do mesmo
    Tendo cada elemento sua devida cor.
    (Cor está presente nas classes).
    */
    private static String verificaSeTemElemento(Integer x, Integer y) {
        for(Veiculo veiculo : veiculos){
            if(veiculo.isMesmaPosicao(x, y)){
                return veiculo.getCor();
            }
        }
        
        for(Fabrica fabrica : fabricas){
            if(fabrica.isMesmaPosicao(x, y)){
                return fabrica.getCor();
            }
        }
        
        /*
        Retorna  que o Fundo mantenha-se em Branco (bordas do mapa) e preto (fundo do mapa)
        */
        return (Objects.equals(x, TAMANHO_X) || x == 0 
                || Objects.equals(y, TAMANHO_Y) || y == 0 
                    ? BRANCO
                    : DEFAULT).getCor();
    }

    private static void criaNovosVeiculos() {
        List<Veiculo> novosVeiculos = new ArrayList<>();
        
        for (Fabrica fabrica : fabricas){
            for (Veiculo veiculo : veiculos){
                
                if(fabrica.isMesmaPosicao(veiculo) && !veiculo.isFabrica()){
                    veiculo.setFabrica(Boolean.TRUE);
                    novosVeiculos.add(criaVeiculo(veiculo.getClass()));
                    
                } else if (veiculo.isFabrica()){
                    veiculo.setFabrica(Boolean.FALSE);
                }
            }
        }
        
        veiculos.addAll(novosVeiculos);
    }

    private static String getScore() {
        int bicicletas = 0;
        int motos = 0;
        int carros = 0;
        int caminhoes = 0;
        
        for (Veiculo veiculo : veiculos){
            if (veiculo instanceof Bicicleta){
               bicicletas ++;
            }
            if (veiculo instanceof Moto){
               motos ++;
            }
            if (veiculo instanceof Carro){
               carros ++;
            }
            if (veiculo instanceof Caminhao){
               caminhoes ++;
            }
        }
        
        return VERDE.getCor() + "Bicicletas: " + bicicletas + 
               AZUL.getCor() + ", Motos: " + motos + 
               VERMELHO.getCor() + ", Carros:" + carros + 
               AMARELO.getCor() + ", Caminhões: " + caminhoes;        
    }
        
}
