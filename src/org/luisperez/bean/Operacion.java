
package org.luisperez.bean;

/**
 *
 * @author Luis Carlos Pérez
 * @date 25/03/2022
 * @time 08:43:38
 *
 */
public abstract class Operacion {
    //Atributos
    private float numero1;
    private float numero2;
    private float resultado;
    private char operador;
    
    //Constructores
    
    //Constructor nulo
    public Operacion(){
    
    }
    
    //Constructor con parametros
    public Operacion(float numero1, float numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    
    //Metodos getter´s y setter´s
    public float getNumero1(){
        return this.numero1;
    }
    
    public void setNumero1(float numero1){
        this.numero1 = numero1;
    }
    
    public float getNumero2(){
        return this.numero2;
    }
    
    public void setNumero2(float numero2){
        this.numero2 = numero2;
    }
    
    public float getResultado(){
        return this.resultado;
    }
    
    public void setResultado(float resultado){
        this.resultado = resultado;
    }
    
    public float getOperador(){
        return this.operador;
    }
    
    public void setOperador(char operador){
        this.operador = operador;
    }
    
    //Metodos
    
    //Metodo abstracto sin parametros
    public abstract float operar();
    
    //Metodo abstracto con parametros
    public abstract float operar(float numero1, float numero2);    
}
