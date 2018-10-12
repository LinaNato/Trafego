/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import java.util.Random;

/**
 *
 * @author carolinacosta
 */
public class Veiculo extends Elemento {
    
    private Float velocidade;
    private Boolean fabrica;
    private String cor;
    private Integer peso;

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

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

        if (x >= 60) {
            this.x = 2f;
        }

        if (y >= 60) {
            this.y = 2f;
        }
        
        if (x <= 1) {
            this.x = 59f;
        }

        if (y <= 1) {
            this.y = 29f;
        }

    }

    public Float getVelocidade() {
        return velocidade;
    }

    public Boolean getFabrica() {
        return fabrica;
    }

    public String getCor() {
        return cor;
    }

    public void setVelocidade(Float velocidade) {
        this.velocidade = velocidade;
    }

    public void setFabrica(Boolean fabrica) {
        this.fabrica = fabrica;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public boolean isColisoes(Veiculo veiculo){
        return this.isMesmaPosicao(veiculo.getX().intValue(), veiculo.getY().intValue());
    }
    
    public boolean isMesmaPosicao(Integer x, Integer y){
        return this.x.intValue() == x && this.y.intValue() == y;
    }
       
}
