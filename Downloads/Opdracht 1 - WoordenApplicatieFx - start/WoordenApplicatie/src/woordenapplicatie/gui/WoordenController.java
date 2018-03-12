package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    WoordenManager manager = new WoordenManager();
  
    private static final String DEFAULT_TEXT =   "een, twee, drie, vier,\n" +
                                                "hoedje van, hoedje van,\n" +
                                                "een, twee, drie, vier,\n" +
                                                "hoedje van papier\n";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;
    
    private boolean newLine = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taOutput.setText(DEFAULT_TEXT);
    }
    
    
    @FXML
    private void aantalAction(ActionEvent event) {
        String[] s = taOutput.getText().split("\\s+");
        System.out.println("Total words: " + manager.countWords(s));
        System.out.println("Total Unique Words: " + manager.countUniqueWords(s));
    }
    
    @FXML
    private void sorteerAction(ActionEvent event) {
        String[] s = taOutput.getText().split("\\s+");
        
        taInput.setText(manager.sort(s).toString());
        
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        String[] s = taOutput.getText().split("\\s+");
        HashMap<Integer, List<String>> map = manager.wordCount(s);
        
        for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
            for(String string : entry.getValue()){
                System.out.println(string + ": " + entry.getKey());
            }
        }
        taInput.setText(manager.wordCount(s).toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        String[] s = taOutput.getText().split("\\s+");
        String text = taOutput.getText();
        taInput.setText(manager.concord(text, s));
    }
   
}
