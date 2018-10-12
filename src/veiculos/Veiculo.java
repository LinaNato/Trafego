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
public class Veiculo {

    private Float y = 0f;
    private Float x = 0f;
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

        if (x > 200) {
            this.x = 0f;
        }

        if (y > 50) {
            this.y = 0f;
        }

    }

    public Float getY() {
        return y;
    }

    public Float getX() {
        return x;
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

    public void setY(Float y) {
        this.y = y;
    }

    public void setX(Float x) {
        this.x = x;
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
        return this.x.equals(veiculo.getX()) && this.y.equals(veiculo.getY());
    }
}
