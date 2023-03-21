/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import interfaces.Interface;
import interfaces.searchAuthor;
import interfaces.searchKeyWords;

/**
 *
 * @author carri
 */
public class InterfaceCode {
        private static final Interface PagePrincipal = new Interface();
        private static final searchAuthor buscarAutor = new searchAuthor();
        private static final searchKeyWords buscarPalabras = new searchKeyWords();
        
        

        public static void openMainPage(){
            getMain().setVisible(true);
        }
        
   
        // Methods to initialize my interface 
    public static Interface getMain() {
        return PagePrincipal;
    }
    
    public static searchAuthor getAuthorInterface(){
        return buscarAutor;
    }
    
    public static searchKeyWords getKeyWordsInterface(){
        return buscarPalabras;
    }
    
    public static void returnToMainPage(){
        getMain().setVisible(true); 
        
        getAuthorInterface().setVisible(false);
        getKeyWordsInterface().setVisible(false);
        
        
        
    }
    
    public static void openSearchAuthor(){
        getAuthorInterface().setVisible(true);
        getMain().setVisible(false);
    }
    
    public static void openSearchKeyWords(){
        getKeyWordsInterface().setVisible(true);
        getMain().setVisible(false);
        
        
    }


    
}