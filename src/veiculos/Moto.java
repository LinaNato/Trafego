/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import static utils.Constantes.CoresBackground.AZUL;

/**
 *
 * @author carolinacosta
 */
public class Moto extends Veiculo{

    private String tipo;
    
    public Moto() {
        super.setVelocidade(3F);
        super.setPeso(2);
        super.setCor(AZUL.getCor());
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
