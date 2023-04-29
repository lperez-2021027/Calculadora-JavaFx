
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 29/03/2022
 * @time 08:36:37
 *
 */
public class Reciproco extends Operacion{
    
    //Constructor nulo
    public Reciproco(){
    
    }
    
    @Override
    public float operar(){
        setResultado(getNumero1() / getNumero2());
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setResultado(getNumero1() / getNumero2());
        return getResultado();
    }
    
}
