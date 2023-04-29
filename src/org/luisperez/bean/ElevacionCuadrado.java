
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 29/03/2022
 * @time 21:18:26
 *
 */
public class ElevacionCuadrado extends Operacion{
    
    @Override
    public float operar(){
        setOperador('^');
        setResultado(( float) Math.pow(getNumero1(), getNumero2()));
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setOperador('^');
        setNumero1(numero1);
        setNumero2(numero2);
        setResultado( (float) Math.pow(getNumero1(), getNumero2()));
        return getResultado();
    }
    
}
