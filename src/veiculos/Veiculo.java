
package veiculos;

import java.util.Random;
import static utils.Constantes.TAMANHO_X;
import static utils.Constantes.TAMANHO_Y;

/**
 *
 * @author carolinacosta
 */
public class Veiculo extends Elemento {
/*
    Atribuindo variáveis da super classe veículo
    */    
    private Float velocidade;
    private Boolean fabrica = Boolean.FALSE;
    private Integer peso;

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    /*
    Criando o movimento de veículo
    Os movimentos são randômicos e podem ser realizados nas 4 direções
    Utilizando a velocidade que cada veiculo possui
    */
    public void move() {
        Random random = new Random();
        Boolean v = random.nextBoolean();

        int direcao = 1 + (int) (Math.random() * 2);
        if (direcao == 1) {
            if (v) {
                x += this.velocidade;
            } else {
                x -= this.velocidade;
            }
        } else {
            if (v) {
                y += this.velocidade;
            } else {
                y -= this.velocidade;
            }
        }

        /*
        Condição que verifica posição em x e y do veículo e faz o mundo ser cíclico
        */
        if (x >= TAMANHO_X -1) {
            this.x = 2f;
        }

        if (y >= TAMANHO_Y -1) {
            this.y = 2f;
        }
        
        if (x <= 1) {
            this.x = new Float(TAMANHO_X -1);
        }

        if (y <= 1) {
            this.y = new Float(TAMANHO_Y -1);
        }

    }
    
    /*
    Criando metodos getters e setters
    */

    public Float getVelocidade() {
        return velocidade;
    }

    /**
     *
     * @return
     */
    public Boolean isFabrica() {
        return fabrica;
    }

    public void setVelocidade(Float velocidade) {
        this.velocidade = velocidade;
    }

    public void setFabrica(Boolean fabrica) {
        this.fabrica = fabrica;
    }
  
}
