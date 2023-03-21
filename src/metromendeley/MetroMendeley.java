/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metromendeley;

import aplication.Functions;
import aplication.Global;
import java.io.IOException;


/**
 *
 * @author carri
 */
public class MetroMendeley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Functions fc = new Functions();
        Global.initializeApp();
        fc.access_new_file();
        
    }
    
}
