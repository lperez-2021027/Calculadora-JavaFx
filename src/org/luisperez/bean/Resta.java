
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 25/03/2022
 * @time 09:20:37
 *
 * Carne: 2021027
 * Codigo tecnico: IN5BM
 * Grupo: 2 (Lunes)
 */
public class Resta extends Operacion{
    
    @Override
    public float operar(){
        setOperador('-');
        setResultado(getNumero1() - getNumero2());
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador('-');
        setResultado(getNumero1() - getNumero2());
        return getResultado();
    }    
}
