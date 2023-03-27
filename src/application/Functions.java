/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import primitivas.Author;
import primitivas.KW;
import primitivas.KeyWords;
import primitivas.List;
import primitivas.Node;
import primitivas.Summary;

/**
 *
 * @author Andres
 */
public class Functions {

    /*
    Este metodo devuelvew el contenido dentro de un txt
     */
    public String read_txt(String path) {
        String texto = "";
        Summary resumen = null;
        try {

            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    texto += linea + "\n";
                }
            }

            br.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
        }
        return texto;
    }

    /*
    Este metodo devuelve un Summary con parametro de loleido en un archivo de texto
     */
    public Summary read_string(String summaryS) {
        try {
            String[] elementosDelResumen = summaryS.split("Autores");
            String[] autores_resumenpalabras = elementosDelResumen[1].split("Resumen");
            String[] autores = autores_resumenpalabras[0].split("\n");

            String autoresS = "";
            for (int i = 1; i < autores.length; i++) {
                if (i != autores.length - 1) {
                    autoresS += autores[i] + "\n";
                } else {
                    autoresS += autores[i];
                }
            }
            String[] resumen_palabras = autores_resumenpalabras[1].split("\n");
            String[] palabras = resumen_palabras[2].split(":");
            String[] pc = palabras[1].split(",");

            Summary newSummary = new Summary(pc.length);
            newSummary.setAuthors(autoresS);
            newSummary.setTitle(elementosDelResumen[0]);
            newSummary.setBody(resumen_palabras[1]);

            for (int i = 0; i < pc.length; i++) {
                KW kwAux = new KW(pc[i], (resumen_palabras[1].split(pc[i]).length - 1));
                Node<KW> pAux = new Node<>(kwAux);
                if (newSummary.getKeywords().getArray()[i] != null) {
                    newSummary.getKeywords().getArray()[i].addEnd(pAux);
                } else {
                    List nuevaLista = new List(pAux);
                    newSummary.getKeywords().getArray()[i] = nuevaLista;
                }
            }

            return newSummary;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
        }
        return null;
    }

    /*
    Este metodo devuelve un string de todo lo leido en el txt donde se guardan la sdirecciones de los resumenes guardados previamente
     */
    public String read_directions() {
        String direcciones = read_txt("src\\archive\\direcciones.txt");
        return direcciones;
    }

    /*
    Este procedimeinto inicializa la informacion a la hora de empezar el programa
     */
    public void initializeData() {
        String[] direcciones = read_directions().split("\n");
        for (int i = 0; i < direcciones.length; i++) {
            String resumenS = read_txt(direcciones[i]);
            this.read_file(resumenS);
        }

    }

    /*
    Este metodo agrega a las variables globales todos los datos que son atributos de ella tras recibir el texto del archivo leido.
    Devuelve un booleano en caso de que ya se encuentre registrado o no lo que se quiere agregar
     */
    public boolean read_file(String fileS) {
        //Aqui estamos agragando los resumenes
        Summary resumen = read_string(fileS);
        int peso = 0;
        String titulo = resumen.getTitle().toLowerCase().replace("\n", "");
        int longitud = titulo.length();
        for (int j = 0; j < titulo.length(); j++) {
            char letra = titulo.charAt(j);
            peso += ((int) letra);
        }
        int posicion = peso % 521;
        if (Global.summaries.getArray()[posicion] == null) {
            List lAux1 = new List();
            Global.summaries.getArray()[posicion] = lAux1;
        }
        Global.summaries.getArray()[posicion].addSummariesToArray(resumen);
        if (!resumen.getIsRepeated()) {
            //Aqui estamos agregando los autores
            String[] autores = resumen.getAuthors().split("\n");
            for (int j = 0; j < autores.length; j++) {
                int pesoA = 0;
                String autor = autores[j].toLowerCase();
                for (int k = 0; k < autores[j].length(); k++) {
                    pesoA += (int) autor.charAt(k);
                }
                int posicionA = pesoA % 1031;
                if (Global.authors.getArray()[posicionA] == null) {
                    List lAux2 = new List();
                    Global.authors.getArray()[posicionA] = lAux2;
                }
                Global.authorsDisp.agregarAutorAlDisplay(autores[j]);
                Global.authors.getArray()[posicionA].addAuthorToArray(autores[j], resumen.getTitle());
            }

            //Aqui estamos agragando el hashtable de las palabras clave
            for (int j = 0; j < resumen.getKeywords().getArray().length; j++) {
                Node<KW> pAux = resumen.getKeywords().getArray()[j].getpFirst();
                int pesoKW = 0;
                String palabra = pAux.getData().getPalabra().toLowerCase();
                if (palabra.contains(".")){
                    palabra = palabra.replace(".", "");
                }
                for (int k = 1; k < palabra.length(); k++) {
                    pesoKW += (int) palabra.charAt(k);
                }
                int posicionKW = pesoKW % 4099;
                if (Global.keyWords.getArray()[posicionKW] == null) {
                    List lAux3 = new List();
                    Global.keyWords.getArray()[posicionKW] = lAux3;
                }
                Global.keyWords.getArray()[posicionKW].addToKeyWordsHash(pAux.getData().getPalabra(), resumen.getTitle());
            }

            Global.summariesDisp.addToListInAlphabeticalOrder(resumen);

        }
        return resumen.getIsRepeated();
    }

    
    /*
    Dado un archivo, se lee y se empieza a agregart a las variables globales, en caso de que ya este, no hace mas nada. Si no esta, agrega a las 
    variables globales los datos nuievos y agrega la direccion all archivo direcciones.txt
    */
    public void access_new_file() throws IOException {
        boolean registered = false;
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("", ".txt", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(fc);
        String path = fc.getSelectedFile().getAbsolutePath();
        File fileImport = new File(path);

        String newPath = "src\\archive\\" + fileImport.getName();
        String contenido = this.read_txt(path);

        File newFile = new File(newPath);
        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            PrintWriter pw = new PrintWriter(newFile.getAbsolutePath());
            pw.write(contenido);
            pw.close();
            registered = this.read_file(contenido);
            JOptionPane.showMessageDialog(null, "Archivo leido Exitosamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        if (!registered) {
            try {
                String direcciones = "";
                direcciones = this.read_directions() + newPath;
                PrintWriter pw = new PrintWriter("src\\archive\\direcciones.txt");
                pw.print(direcciones);
                pw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ocurrio un error añadiendo al nueva direccion: " + e);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya había sido agregado.");
        }
    }

    /*
    Procedimiento que carga la data incial.
    */
    public void loadIntialData() {
        String direcciones = this.read_directions();
        String[] direccion = direcciones.split("\n");
        for (int i = 0; i < direccion.length - 1; i++) {
            String data = this.read_txt(direccion[i]);
            this.read_file(data);
        }
    }
}
