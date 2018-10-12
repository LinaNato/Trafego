/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author carolinacosta
 */
public class Bicicleta extends Veiculo{
    public Bicicleta() {
        super.setVelocidade(0.5F);
        super.setPeso(1);
        super.setCor("\u001B[42m");
    }    
}
