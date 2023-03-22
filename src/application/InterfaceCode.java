/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import interfaces.Interface;
import interfaces.searchAuthor;
import interfaces.searchKeyWords;
import interfaces.searchSummary;

/**
 *
 * @author carri
 */
public class InterfaceCode {

    private static final Interface PagePrincipal = new Interface();
    private static final searchAuthor buscarAutor = new searchAuthor();
    private static final searchKeyWords buscarPalabras = new searchKeyWords();
    private static searchSummary buscarResumenes = new searchSummary();

    public static void openMainPage() {
        Functions f = new Functions();
        f.initializeData();
        getMain().setVisible(true);
    }

    // Methods to initialize my interface 
    public static Interface getMain() {
        return PagePrincipal;
    }

    public static searchAuthor getAuthorInterface() {
        return buscarAutor;
    }

    public static searchKeyWords getKeyWordsInterface() {
        return buscarPalabras;
    }

    public static void returnToMainPage() {
        getMain().setVisible(true);
        getAuthorInterface().setVisible(false);
        getKeyWordsInterface().setVisible(false);

    }
    
    public static void openSearhSummaries(){
        getMain().setVisible(false);
        getBuscarResumenes().llenarComboBox();
        getBuscarResumenes().setVisible(true);
        
    }

    public static void openSearchAuthor() {
        getAuthorInterface().setVisible(true);
        getMain().setVisible(false);
        getAuthorInterface().llenarComboBox();
    }

    public static void openSearchKeyWords() {
        getKeyWordsInterface();
        getKeyWordsInterface().setVisible(true);
        getMain().setVisible(false);

    }
    public static void exitInterface(){
        getMain().setVisible(false);
        getAuthorInterface().setVisible(false);
        getKeyWordsInterface().setVisible(false);
        
    }

    /**
     * @return the buscarResumenes
     */
    public static searchSummary getBuscarResumenes() {
        return buscarResumenes;
    }

    /**
     * @param aBuscarResumenes the buscarResumenes to set
     */
    public static void setBuscarResumenes(searchSummary aBuscarResumenes) {
        buscarResumenes = aBuscarResumenes;
    }

}
