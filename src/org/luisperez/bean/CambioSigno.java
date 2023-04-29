
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 25/03/2022
 * @time 12:25:48
 *
 * Carne: 2021027
 * Codigo tecnico: IN5BM
 * Grupo: 2 (Lunes)
 */
public class CambioSigno extends Operacion{
    
    @Override
    public float operar(){
        setOperador('_');
        setResultado(getNumero1() * getNumero2());
        return getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        setOperador('_');
        setNumero1(numero1);
        setNumero2(numero2);
        setResultado(getNumero1() * getNumero2());
        return getResultado();
    }
    
    /*
    Con anterioridad tome la decision de no heredar la clase operacion,
    pero decidi hacerlo al final para aplicar correctamente el polimorfismo.    
    
    //Atributos
    private float numero1;
    private float resultado;
    private char operador;
    
    //Constructores
    
    //Constructor nulo
    public CambioSigno(){
    
    }
    
    //Constructor con parametros
    public CambioSigno(float numero1){
        this.numero1 = numero1;
    }
    
    //Metodos Getter´s y Setter´s
    public float getNumero1(){
        return this.numero1;
    }
    
    public void setNumero1(float numero1){
        this.numero1 = numero1;
    }
    
    public float getResultado(){
        return this.resultado;
    }
    
    public void setResultado(float resultado){
        this.resultado = resultado;
    }
    
    public char getOperador(){
        return this.operador;
    }
    
    public void setOperador(char operador){
        this.operador = operador;
    }
    
    //Metodos
    
    //Metodo sin parametros
    public float cambiar(){
        setOperador('-');
        setResultado(this.numero1 * -1);
        return getResultado();
    }
    
    //Metodo con parametros
    public float cambiar(float numero1){
        setNumero1(numero1);
        setOperador('!');
        setResultado(getNumero1() * -1);
        return getResultado();
    }*/
}
