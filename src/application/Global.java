/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import primitivas.HashTable;
import primitivas.List;

/**
 *
 * @author Andres
 */
public class Global {
    
  public static HashTable summaries;
  public static HashTable keyWords;
  public static HashTable authors;
  public static List summariesDisp;
  public static List authorsDisp;
  
  public static void initializeApp(){
      summaries = new HashTable(521);
      authors = new HashTable(1031);
      keyWords = new HashTable(4099);
      summariesDisp = new List();
      authorsDisp = new List();
      
  }
    
  
  
}
