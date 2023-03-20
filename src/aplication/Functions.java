/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplication;

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

    public Summary read_string(String summaryS) {
        try {
            String[] elementosDelResumen = summaryS.split("Autores");
            String[] autores_resumenpalabras = elementosDelResumen[1].split("Resumen");
            String[] autores = autores_resumenpalabras[0].split("\n");

            String autoresS = "";
            for (int i = 1; i < autores.length; i++) {
                if (i != autores.length - 1) {
                    autoresS += autores[i] + "\n";
                }else{
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
                if (newSummary.getKeywords().getArray()[i] != null){
                newSummary.getKeywords().getArray()[i].addEnd(pAux);
                }else{
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

    public String read_directions() {
        String direcciones = read_txt("src\\archive\\direcciones.txt");
        return direcciones;
    }

    public void initializeData() {
        String[] direcciones = read_directions().split("\n");
        for (int i = 0; i < direcciones.length; i++) {
            read_file(direcciones[i]);

        }

    }

    public void read_file(String fileS) {
        //Aqui estamos agragando los resumenes
        Summary resumen = read_string(fileS);
        int peso = 0;
        String titulo = resumen.getTitle().toLowerCase();
        for (int j = 0; j < titulo.length(); j++) {
            peso += ((int) titulo.charAt(j));
        }
        int posicion = peso % 521;
        Global.summaries.getArray()[posicion].addSummariesToArray(resumen);
        //Aqui estamos agregando los autores
        String[] autores = resumen.getAuthors().split("\n");
        for (int j = 0; j < autores.length; j++) {
            int pesoA = 0;
            for (int k = 0; k < 10; k++) {
                pesoA += (int) autores[j].charAt(k);
            }
            int posicionA = pesoA % 1031;
            Global.authors.getArray()[posicionA].addAuthorToArray(autores[j], resumen.getTitle());
        }

        //Aqui estamos agragando el hashtable de las palabras clave
        for (int j = 0; j < resumen.getKeywords().getArray().length; j++) {
            Node<KeyWords> pAux = resumen.getKeywords().getArray()[j].getpFirst();
            int pesoKW = 0;
            for (int k = 0; k < pAux.getData().getWord().length(); k++) {
                pesoKW += (int) pAux.getData().getWord().charAt(k);
            }
            int posicionKW = pesoKW % 4099;
            Global.keyWords.getArray()[posicionKW].addToKeyWordsHash(pAux.getData().getWord(), resumen.getTitle());
        }

        Global.summariesDisp.addToListInAlphabeticalOrder(resumen);

    }

    public void acces_new_file() throws IOException {
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
            this.read_string(contenido);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

//        String newPath = "archive\\" + f.getName();
////        if (!f2.exists()) {
//            String texto = this.read_txt(path);
//            try {
//                PrintWriter pw = new PrintWriter(newPath);
//                pw.write(texto);
//                pw.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Ocurrio un error.");
//            }   
//            read_file(newPath);
//
////        } else {
//            JOptionPane.showMessageDialog(null, "Ya existe este archivo.");
////        }
}
