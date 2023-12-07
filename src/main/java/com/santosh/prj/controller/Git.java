package com.santosh.prj.controller;


import com.santosh.prj.service.GitClone;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Git
{
   public HBox finishHbox;
   public ImageView loader;
   public Button gitClone;
   public HBox startHbox;
   public HBox cloneHbox;
   public HBox buildHbox;

   @FXML
   private void initialize()
   {
      loader.setVisible(false);
   }

   public void onClone(ActionEvent actionEvent)
   {
      GitClone gitClone = new GitClone();

      loader.setVisible(true);
      setProcessColor(startHbox);
      Thread cloneThread = new Thread(() -> {
         //addDelay();
         setProcessColor(cloneHbox);
         gitClone.startClone();
         // addDelay();
         setProcessColor(buildHbox);
         gitClone.startBuild();
         //addDelay();
         setProcessColor(finishHbox);
         loader.setVisible(false);
      });
      cloneThread.start();
   }

   private void setProcessColor(HBox box)
   {
      Platform.runLater(() -> {
         for (javafx.scene.Node node : box.getChildren()) {
            if (node instanceof Line) {
               ((Line) node).setStroke(Color.rgb(30, 144, 255));
            } else {
               node.setStyle("-fx-fill: #1e90ff");
               ((Circle) node).setStroke(Color.WHITE);
            }
         }
      });
   }

   private void addDelay()
   {
      int timeToWait = 10; //second
      System.out.print("Scanning");
      try {
         for (int i = 0; i < timeToWait; i++) {
            Thread.sleep(1000);
            System.out.print(".");
         }
      }
      catch (InterruptedException ie) {
         Thread.currentThread().interrupt();
      }
   }
}
