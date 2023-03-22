/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import primitivas.Author;
import primitivas.HashTable;
import primitivas.KeyWords;
import primitivas.Node;
import primitivas.Summary;
import primitivas.SummaryTitle;

/**
 *
 * @author Andres
 */
public class InterfaceFuncitons {

    /*
    Estos metodos son para la busqueda del resumen
     */
    public Summary searchSummaryByName(String title) {
        int peso = 0;
        String titleLower = title.toLowerCase();
        for (int i = 0; i < title.length(); i++) {
            peso += title.charAt(i);
        }
        for (int i = 0; i < Global.summaries.getArray()[peso].getSize(); i++) {
            Node<Summary> pAux = Global.summaries.getArray()[i].getpFirst();
            if (pAux.getData().getTitle().equalsIgnoreCase(title)) {
                return pAux.getData();
            }
            pAux = pAux.getpNext();
        }
        return null;
    }

    /*
    Estos metoos son para la busqueda de la palabra clave
     */
    public KeyWords searchKeywordByName(String keyword) {
        int peso = 0;
        String keywordLower = keyword.toLowerCase();
        for (int i = 1; i < keywordLower.length(); i++) {
            peso += keywordLower.charAt(i);
        }
        int posicion = peso % 4099;
        try {
            for (int i = 0; i < Global.keyWords.getArray()[peso].getSize(); i++) {
                Node<KeyWords> pAux = Global.keyWords.getArray()[peso].getpFirst();
                if (pAux.getData().getWord().equalsIgnoreCase(keyword)) {
                    return pAux.getData();
                }
                pAux = pAux.getpNext();
            }
        } catch (Exception e) {

        }
        return null;
    }

    public String deKeywordAString(String name) {
        String texto = "";
        KeyWords keyword = searchKeywordByName(name);
        if (keyword != null) {
            Node<SummaryTitle> pAux = keyword.getSummary().getpFirst();
            for (int i = 0; i < keyword.getSummary().getSize(); i++) {
                texto += pAux.getData().getTitle();
            }
        }
        return texto;
    }

    /*
    Estos metodos son para la busqueda del autor
     */
    public Author searchAuthorByName(String name) {
        int peso = 0;
        String nameLower = name.toLowerCase();
        for (int i = 0; i < nameLower.length(); i++) {
            peso += (int) nameLower.charAt(i);
        }
        int posicion = peso % 1031;
        for (int i = 0; i < Global.authors.getArray()[posicion].getSize(); i++) {
            Node<Author> pAux = Global.authors.getArray()[posicion].getpFirst();
            if (pAux.getData().getName().equalsIgnoreCase(name)) {
                return pAux.getData();
            }
            pAux = pAux.getpNext();
        }
        return null;
    }

    public String deAutorAString(String name) {
        String texto = "";
        Author autor = searchAuthorByName(name);
        Node<SummaryTitle> pAux = autor.getSummaries().getpFirst();
        for (int i = 0; i < autor.getSummaries().getSize(); i++) {
            texto += pAux.getData().getTitle();
        }
        return texto;
    }

    /*
    Este metodo devuleve un array de los nombres de los resumenes guardados.
     */
    public String[] deListaDeResumenesAArray() {
        String[] resumenes = new String[Global.summariesDisp.getSize()];
        Node<SummaryTitle> pAux = Global.summariesDisp.getpFirst();
        for (int i = 0; i < resumenes.length; i++) {
            resumenes[i] = pAux.getData().getTitle();
            pAux = pAux.getpNext();
        }
        return resumenes;
    }

    /*
    Este método devuelve un array de los nombres de los autores guatdados 
     */
    public String[] deListaDeAutoresAArray() {
        String[] autores = new String[Global.authorsDisp.getSize()];
        Node<Author> pAux = Global.authorsDisp.getpFirst();
        for (int i = 0; i < autores.length; i++) {
            autores[i] = pAux.getData().getName();
            pAux = pAux.getpNext();
        }
        return autores;
    }

}
