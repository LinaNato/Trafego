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
public class Caminhao extends Veiculo{
    
    private Integer capacidade_carga;
    
    public Caminhao() {
        super.setVelocidade(1F);
        super.setPeso(4);
        super.setCor("\u001B[43m");
    }
    
    
}
