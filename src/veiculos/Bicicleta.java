
package veiculos;

import static utils.Constantes.CoresBackground.VERDE;

/**
 *
 * @author carolinacosta
 */
public class Bicicleta extends Veiculo{
    public Bicicleta() {
        super.setVelocidade(0.5F);
        super.setPeso(1);
        super.setCor(VERDE.getCor());
    }    
}
