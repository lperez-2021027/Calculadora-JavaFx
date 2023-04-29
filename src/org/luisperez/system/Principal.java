
package org.luisperez.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Luis Carlos Pérez
 * @date 25/03/2022
 * @time 08:41:52
 *
 * Carne: 2021027
 * Codigo tecnico: IN5BM
 * Grupo: 2 (Lunes)
 */
public class Principal extends Application{
    
    public static void main(String[] args) {        
        launch(args);        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/FXMLCalcuView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
