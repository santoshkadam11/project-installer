package com.amadeus.cyt;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class PrjSetup
      extends Application
{
   double x, y = 0;

   @Override
   public void start(Stage stage)
         throws IOException
   {
      Parent root = FXMLLoader.load(Objects.requireNonNull(CytSetup.class.getResource(
            "cyt-setup.fxml")));
      Scene scene = new Scene(root);
      stage.initStyle(StageStyle.UNDECORATED);
      //grab your root here
      root.setOnMousePressed(event -> {
         x = event.getSceneX();
         y = event.getSceneY();
      });

      //move around here
      root.setOnMouseDragged(event -> {
         stage.setX(event.getScreenX() - x);
         stage.setY(event.getScreenY() - y);
      });


      stage.setScene(scene);
      stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/img/logo-cyt.png"))));
      stage.show();
   }

   public static void main(String[] args)
   {
      launch();
   }
}
