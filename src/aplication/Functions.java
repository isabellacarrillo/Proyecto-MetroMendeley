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
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import primitivas.KW;
import primitivas.KeyWords;
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

    public Summary read_string(String path) {
        try {
            String texto = read_txt(path);
            String[] elementosDelResumen = texto.split("\n\n");
            String[] autores = elementosDelResumen[1].split("\n");
            String autoresS = "";
            for (int i = 1; i < autores.length; i++) {
                autoresS += autores[i];
            }
            String[] content = elementosDelResumen[2].split("\n");
            String[] palabras = elementosDelResumen[3].split(":");
            String[] pc = palabras[1].split(",");

            Summary newSummary = new Summary(pc.length);
            newSummary.setAuthors(autoresS);
            newSummary.setTitle(elementosDelResumen[0]);
            newSummary.setBody(content[1]);

            for (int i = 0; i < pc.length; i++) {
                KW kwAux = new KW(pc[i], (content[1].split(pc[i]).length - 1));
                Node<KW> pAux = new Node<>(kwAux);
                newSummary.getKeywords().getArray()[i].addEnd(pAux);
            }

            return newSummary;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
        }
        return null;
    }

    public String read_directions() {
        String direcciones = read_txt("archive\\direcciones.txt");
        return direcciones;
    }

    public void initializeData() {
        String[] direcciones = read_directions().split("\n");
        for (int i = 0; i < direcciones.length; i++) {
            read_file(direcciones[i]);

        }

    }

    public void read_file(String route) {
        //Aqui estamos agragando los resumenes
        Summary resumen = read_string(route);
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

    public void acces_new_file() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("", ".txt", "txt");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(fc);
        String path = fc.getSelectedFile().getAbsolutePath();
        File f = new File(path);
        String newPath = "archive\\" + f.getPath();
        File f2 = new File(newPath);
        if (!f2.exists()) {
            String texto = this.read_txt(path);
            try {
                FileWriter fr = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fr);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(texto);
                pw.close();
                bw.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error.");
            }
            read_file(texto);

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe este archivo.");
        }
    }

}
