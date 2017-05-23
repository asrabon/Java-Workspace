package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private Button button1;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseOver() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleY(1.0);
        label.setScaleX(1.0);
    }

    @FXML
    public void handleOpenClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Application File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image" , "*.img", "*.png", "*.jpg"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        List<File> fileList = fileChooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        File file = directoryChooser.showDialog(gridPane.getScene().getWindow());
        if(fileList != null) {
            for(File file : fileList) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Chooser was cancelled.");
        }
    }

    @FXML
    public void handleLinkClick() {
        System.out.println("The link was clicked.");
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        WebEngine engine = webView.getEngine();
        engine.load("http://javafx.com");
    }

}
