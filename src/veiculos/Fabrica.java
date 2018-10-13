package veiculos;

import static utils.Constantes.CoresBackground.ROXO;

/**
 *
 * @author carolinacosta
 */
public class Fabrica extends Elemento{ 
    
    private int largura = 3;
    private int altura = 3;
    
    public Fabrica(){
        super.setCor(ROXO.getCor());
    }
    
    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    @Override
    public boolean isMesmaPosicao(Integer x, Integer y) {
        return this.x.intValue() >= x && this.x.intValue() <= (x + largura)
                && this.y.intValue() >= y && this.y.intValue() <= (y + altura);
    } 
    
}
