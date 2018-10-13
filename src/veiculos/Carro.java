/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import static utils.Constantes.CoresBackground.VERMELHO;

/**
 *
 * @author carolinacosta
 */
public class Carro extends Veiculo{
    
    private Integer num_passageiros;
    
    public Carro(){
        super.setVelocidade(2F);
        super.setPeso(3);
        super.setCor(VERMELHO.getCor());
    }
    
    
}
