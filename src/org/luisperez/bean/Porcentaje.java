
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 25/03/2022
 * @time 12:22:22
 *
 * Carne: 2021027
 * Codigo tecnico: IN5BM
 * Grupo: 2 (Lunes)
 */
public class Porcentaje extends Operacion{
    
    @Override
    public float operar(){
        setOperador('%');
        setResultado((getNumero1() * getNumero2())/100);
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador('%');
        setResultado((getNumero1() * getNumero2()) / 100);
        return getResultado();
    }    
}
