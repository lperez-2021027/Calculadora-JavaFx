
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 29/03/2022
 * @time 11:00:35
 *
 */
public class RaizCuadrada extends Operacion{
    
    @Override
    public float operar(){
        setOperador('r');
        setResultado( (float) Math.sqrt(getNumero2()));//Se castea, se trunca a float
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador('r');
        setResultado( (float) Math.pow(getNumero1(), getNumero2()));
        return getResultado();
    }    
}
