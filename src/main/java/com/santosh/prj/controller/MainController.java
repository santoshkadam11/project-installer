package com.santosh.prj.controller;


import com.santosh.prj.CytSetup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;


public class MainController
      implements Initializable
{

   @FXML
   private Button onClose;

   @FXML
   private Pane innerPane;

   @FXML
   private Button homId;
   @FXML
   private Button onDownload;
   @FXML
   private Button gitId;
   @FXML
   Button dbId;
   @FXML
   Button wlsId;


   private final Stack<String> stackOfPages = new Stack<>();
   private final String[] flow = { "home.fxml", "download.fxml", "git.fxml", "database.fxml", "weblogic.fxml" };
   private int index = 0;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      onClose.setOnMouseClicked(event -> System.exit(0));
      onHomeContent();
   }

   public void onHome(ActionEvent actionEvent)
   {
      onHomeContent();
   }

   private void onHomeContent()
   {
      try {
         stackOfPages.push(flow[0]);
         innerPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(CytSetup.class.getResource(flow[0]))));
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public void onDownload(ActionEvent actionEvent)
   {
      loadContent(flow[1]);
   }

   public void onGit(ActionEvent actionEvent)
   {
      loadContent(flow[2]);
   }

   public void onDatabase(ActionEvent actionEvent)
   {
      loadContent(flow[3]);
   }

   public void onWeblogic(ActionEvent actionEvent)
   {
      loadContent(flow[4]);
   }

   public void loadContent(String fxml)
   {
      if (stackOfPages.isEmpty() || stackOfPages.peek().equals(fxml)) {
         return;
      }
      innerPane.getChildren().clear();
      try {
         stackOfPages.push(fxml);
         innerPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(CytSetup.class.getResource(fxml))));
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public void onNext(ActionEvent actionEvent)
   {

      if (index == flow.length - 1) {
         return;
      }
      //add pressed button css style when next button is pressed

      innerPane.getChildren().clear();
      try {

         stackOfPages.push(flow[++index]);
         addPressedButtonCss(stackOfPages.peek());
         innerPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(CytSetup.class.getResource(flow[index]))));
      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   private void addPressedButtonCss(String peek) {
      if(peek.equals("home.fxml")){
         homId.getStyleClass().add("button-pressed");
         onDownload.getStyleClass().remove("button-pressed");
         gitId.getStyleClass().remove("button-pressed");
         dbId.getStyleClass().remove("button-pressed");
         wlsId.getStyleClass().remove("button-pressed");
      }
      else if(peek.equals("download.fxml")){
         homId.getStyleClass().remove("button-pressed");
         onDownload.getStyleClass().add("button-pressed");
         gitId.getStyleClass().remove("button-pressed");
         dbId.getStyleClass().remove("button-pressed");
         wlsId.getStyleClass().remove("button-pressed");
      }
      else if(peek.equals("git.fxml")){
         homId.getStyleClass().remove("button-pressed");
         onDownload.getStyleClass().remove("button-pressed");
         gitId.getStyleClass().add("button-pressed");
         dbId.getStyleClass().remove("button-pressed");
         wlsId.getStyleClass().remove("button-pressed");
      }
      else if(peek.equals("database.fxml")){
         homId.getStyleClass().remove("button-pressed");
         onDownload.getStyleClass().remove("button-pressed");
         gitId.getStyleClass().remove("button-pressed");
         dbId.getStyleClass().add("button-pressed");
         wlsId.getStyleClass().remove("button-pressed");
      }
      else if(peek.equals("weblogic.fxml")){
         homId.getStyleClass().remove("button-pressed");
         onDownload.getStyleClass().remove("button-pressed");
         gitId.getStyleClass().remove("button-pressed");
         dbId.getStyleClass().remove("button-pressed");
         wlsId.getStyleClass().add("button-pressed");
      }
   }

   public void onPrev(ActionEvent actionEvent)
   {
      if (index == 0 || stackOfPages.isEmpty()) {
         return;
      }

      innerPane.getChildren().clear();
      try {
         stackOfPages.pop();
         index--;
         addPressedButtonCss(stackOfPages.peek());
         innerPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(CytSetup.class.getResource(stackOfPages.peek()))));

      }
      catch (IOException e) {
         throw new RuntimeException(e);
      }
   }


}
