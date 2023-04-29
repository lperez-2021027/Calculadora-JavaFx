package org.luisperez.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// Importar lo necesario cuando sea necesario :D
import org.luisperez.bean.Suma;
import org.luisperez.bean.Resta;
import org.luisperez.bean.Multiplicacion;
import org.luisperez.bean.Division;
import org.luisperez.bean.Porcentaje;
import org.luisperez.bean.CambioSigno;
import org.luisperez.bean.ElevacionCuadrado;
import org.luisperez.bean.Operacion;
import org.luisperez.bean.RaizCuadrada;
import org.luisperez.bean.Reciproco;


/**
 * FXML Controller class
 *
 * @author Luis Carlos Pérez
 */
public class FXMLCalcuController implements Initializable {
    
    //Atributos
    private float resultado;
    private float numero;
    private int contadorOperadores;
    private String operadorAnterior;
    private boolean ingresoNuevo = false;
    
    // Inyeccion de objetos
    
    //Pantalla
    @FXML
    private Label lblPantalla;
    
    // Botones Operadores
    @FXML
    private Button btnPunto;    
    @FXML
    private Button btnIgual;    
    @FXML
    private Button btnSumar;    
    @FXML
    private Button btnRestar;    
    @FXML
    private Button btnMultiplicar;    
    @FXML
    private Button btnDividir;    
    @FXML
    private Button btnPorcentaje;    
    @FXML
    private Button btnInvertir;    
    @FXML
    private Button btnReciproco;    
    @FXML
    private Button btnRaizCuadrada;    
    @FXML
    private Button btnCuadrado;    
    @FXML
    private Button btnAc;
    @FXML
    private Button btnBorrar;
    
    // Botones digitos
    @FXML
    private Button btnCero;    
    @FXML
    private Button btnUno;    
    @FXML
    private Button btnDos;    
    @FXML
    private Button btnTres;    
    @FXML
    private Button btnCuatro;    
    @FXML
    private Button btnCinco;    
    @FXML
    private Button btnSeis;    
    @FXML
    private Button btnSiete;    
    @FXML
    private Button btnOcho;    
    @FXML
    private Button btnNueve;    
    @FXML
    private Button clicPunto;
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    // Metodos    
    private void actualizarPantalla(String digito){
                
        if (ingresoNuevo){ //Si se esta realizando un ingreso nuevo se limpia la pantalla
            lblPantalla.setText("");
        } 
        
        lblPantalla.setText(lblPantalla.getText() + digito);
        ingresoNuevo = false;
    }
    
    private void operar(String operador){
        
        if (!(lblPantalla.getText().equals(""))){ // Comprobando si la pantalla tiene algun valor
            
            String strPantalla = lblPantalla.getText();
            
            if (ingresoNuevo == false){
                
                this.numero = Float.parseFloat(strPantalla);
                
                contadorOperadores++;
                                
                if (contadorOperadores == 1){
                    resultado = this.numero;                    
                } else if (contadorOperadores >= 2){

                    Operacion calc = null; 
                    /*Ya que la clase Operacion es abstracta, 
                        no puede se instanciar, por ende se deja con un valor nulo*/

                    switch (this.operadorAnterior){
                        /*Polimorfismo: 
                            comportamiento diferente de un metodo pese a que 
                            este mismo sea escrito exactamente igual*/

                        case "+":
                            //Aplicando polimorfismo
                            calc = new Suma(); //Se instancia la clase suma
                            resultado = calc.operar(resultado, numero); //Procede a sumar
                            break;

                        case "-":
                            calc = new Resta(); //Se instancia la clase resta
                            resultado = calc.operar(resultado, numero); //Procede a restar
                            break;

                        case "*":
                            calc = new Multiplicacion();//...
                            resultado = calc.operar(resultado, numero);
                            break;

                        case "/":
                            calc = new Division();
                            if (numero == 0 || numero == -0){
                                numero = 1;
                            }
                            resultado = calc.operar(resultado, numero);
                            break;

                        case "%":
                            calc = new Porcentaje();
                            resultado = calc.operar(resultado, numero);
                            break;

                        case "+/-":
                            calc = new CambioSigno();
                            resultado = calc.operar(-1,numero);
                            break;

                        case "1/x":
                            calc = new Reciproco();
                            resultado = calc.operar(1, numero);
                            break;
                        
                        /*
                         *Caso particular, ya que la clase RaizCuadrada trabaja con el método pown de
                         *la clase Math tanto la raiz cuadrada y la elevacion al cuadrado pueden trabajar 
                         *con la misma clase y metodo
                        */
                        case "r":
                            calc = new RaizCuadrada();
                            resultado = calc.operar(numero, 0.5f);
                            break;
                            
                        case "^":
                            /*
                            alc = new ElevacionCuadrado();
                            Funciona igualemente instanciando la clase ElevacionCuadrado
                            */
                            calc = new RaizCuadrada();
                            resultado = calc.operar(numero, resultado);
                            break;
                            
                    }//Fin Switch
                    
                    lblPantalla.setText(String.valueOf(this.resultado));
                    
                }// Else if contador
                    
            }// If ingreso nuevo
            
            this.operadorAnterior = operador;
            
        }// If comprobador de espacio vacio
        
        ingresoNuevo = true; // Determina que se esta haciendo un nuevo ingreso
        
    }
    
    private void limpiar(){
        lblPantalla.setText("");
        resultado = 0;
        numero = 0;
        contadorOperadores = 0;
        operadorAnterior = "";
        ingresoNuevo = false;
    }
    
    private void borrar(){
        String texto = lblPantalla.getText();
        if(!(texto.equals(""))){
            if(!(texto.length() <= 1)){
                texto = texto.substring(0, texto.length()-1);
                lblPantalla.setText(texto);
                resultado = Float.parseFloat(lblPantalla.getText());
            } else{
                lblPantalla.setText("");
                
            }// If / else si en pantalla hay un solo valor
            
        } // If comprobacion de pantalla vacia
    }
    
    private void agregarPunto(){
        
        if (ingresoNuevo){
            lblPantalla.setText("");
        }
        
        String cadena = lblPantalla.getText();
        if (cadena.length() <= 0){
            lblPantalla.setText("0.");
            ingresoNuevo = false;
        } else if (!(lblPantalla.getText().contains("."))){ // el: <!> niega la expresion (si esto no es...)
            actualizarPantalla(".");
        }
    }
    
    private void casosEspeciales(){
        if(contadorOperadores != 1)
            ingresoNuevo = false;        
    }
    
    private void operacionEspecial(String op){
        switch(op){
            case "+/-":
                casosEspeciales();
                break;
            case "1/x":
                casosEspeciales();                
                break;
            case "r":
                casosEspeciales();
            case "^":
                casosEspeciales();                
        }
    }
        
    //Metodos On Action
    
    // Botontes de operaciones
    @FXML
    private void clicIgual(){
        if(contadorOperadores >= 1){
            operar(this.operadorAnterior);
            lblPantalla.setText(String.valueOf(this.resultado));
        }        
    }
    
    @FXML
    private void clicSumar(){
        operar("+");
    }
    
    @FXML
    private void clicRestar(){
        operar("-");
    }
    
    @FXML
    private void clicMultiplicar(){
        operar("*");
    }
    
    @FXML
    private void clicDividir(){
        operar("/");
    }
    
    @FXML
    private void clicPorcentar(){
        operar("%");
    }
    
    @FXML
    private void clicInvertir(){   
        contadorOperadores++;
        operadorAnterior = "+/-";
        operacionEspecial(operadorAnterior);
        operar(operadorAnterior);
    }
    
    @FXML
    private void clicReciproco(){
        contadorOperadores++;
        operadorAnterior = "1/x";
        operacionEspecial(operadorAnterior);
        operar(operadorAnterior);        
    }
    
    @FXML
    private void clicRaizCuadrada(){
        contadorOperadores++;
        operadorAnterior = "r";
        operacionEspecial(operadorAnterior);
        operar(operadorAnterior);
    }
    
    @FXML
    private void clicCuadrado(){
        contadorOperadores++;
        resultado = 2;
        operadorAnterior = "^";
        operacionEspecial(operadorAnterior);
        operar(operadorAnterior);
    }
    
    // Botones digitos    
    @FXML
    private void clicCero(){
        
        if(!lblPantalla.getText().equals("")){
            actualizarPantalla("0");
        }
    }
    
    @FXML
    private void clicUno(){
        actualizarPantalla("1");
    }
    
    @FXML
    private void clicDos(){
        actualizarPantalla("2");
    }
    
    @FXML
    private void clicTres(){
        actualizarPantalla("3");
    }
    
    @FXML
    private void clicCuatro(){
        actualizarPantalla("4");
    }
    
    @FXML
    private void clicCinco(){
        actualizarPantalla("5");
    }
    
    @FXML
    private void clicSeis(){
        actualizarPantalla("6");
    }
    
    @FXML
    private void clicSiete(){
        actualizarPantalla("7");
    }
    
    @FXML
    private void clicOcho(){
        actualizarPantalla("8");
    }
    
    @FXML
    private void clicNueve(){
        actualizarPantalla("9");
    }
    
    @FXML
    private void clicPunto(){
        agregarPunto();
    }
    
    //Botones limpiar y borrar
    @FXML
    private void clicLimpiar(){
        limpiar();
    }
    
    @FXML
    private void clicBorrar(){
        borrar();
    }
}
