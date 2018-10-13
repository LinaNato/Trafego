package veiculos;

import utils.Constantes;

/**
 *
 * @author carolinacosta
 */
public class Elemento {
    protected Float y = 0f;
    protected Float x = 0f;
    protected String cor = Constantes.CoresBackground.DEFAULT.getCor();

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }
    
    public boolean isMesmaPosicao(Elemento elemento){
        return this.isMesmaPosicao(elemento.getX().intValue(), elemento.getY().intValue());
    }
    
    public boolean isMesmaPosicao(Integer x, Integer y){
        return this.x.intValue() == x && this.y.intValue() == y;
    }    
    
}
