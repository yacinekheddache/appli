package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
 
public class Test extends Application {
 
     /**objets graphiques représentant un cercle*/
     public  Rectangle rectangle;
     
   /**definir la troupe des objets graphiques*/
        Group root;
 
     /**lancement de l'application*/
     public void start(Stage primaryStage) {
 
        construireScene( primaryStage);
     }
     
    /**construction des objets affichés*/
     void construireScene(Stage primaryStage)  
     {
        int largeur = 800;
        int hauteur = 600;
        //definir la troupe
        root = new Group();
        //definir la scene principale
        Scene scene = new Scene(root, largeur, hauteur, Color.BLACK);
        primaryStage.setTitle("Test de fenêtre...");
        primaryStage.setScene(scene);
 
        //definir les objets graphiques, ici un rectangle
        rectangle = new Rectangle(largeur-largeur/10, hauteur/2, largeur/10, hauteur/10);
        rectangle.setFill(Color.CHARTREUSE);
        //ajouter une gestion d'événement clic souris au rectangle
        rectangle.setOnMouseClicked(event -> {
              System.out.println("mouse click detected! "+event.getSource());
              System.out.println("click on  " + event.getX() + "," + event.getY());
          });
        //ajouter le rectangle à la troupe
        root.getChildren().add(rectangle);
 
        //une transition sur l'opacité de l'objet
        FadeTransition ft = new FadeTransition(Duration.millis(2000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.01);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        ft.play();
       
        //une transition sur la position de l'objet
        TranslateTransition tt = new TranslateTransition(Duration.millis(3000), rectangle);
        tt.setFromX(0);
        //coordonnée relative
        tt.setToX(-largeur+largeur/10);
        tt.setCycleCount(1);
        tt.play();
       
        //afficher le theatre
        primaryStage.show();      
     }
       
     /**lancement du prog*/
     public static void main(String[] args) {
        launch(args);
     }
  }