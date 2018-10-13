
package veiculos;

import static utils.Constantes.CoresBackground.AMARELO;

/**
 *
 * @author carolinacosta
 */
public class Caminhao extends Veiculo{
    
    private Integer capacidade_carga;
    
    public Caminhao() {
        super.setVelocidade(1F);
        super.setPeso(4);
        super.setCor(AMARELO.getCor());
    }
    
    
}
