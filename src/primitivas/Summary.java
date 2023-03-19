/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class Summary {

    private String title;
    private String authors;
    private String body;
    private HashTable keywords;

    //Aqui no estoy segura si poner lo de keywords
    public Summary(String title, String authors, String body, HashTable keywords) {
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.keywords = keywords;
    }

    //Aqui lo que quiero hacer es poner el tamaño de las palabras
    public Summary(int size) {
        this.title = "";
        this.authors = "";
        this.body = "";
        this.keywords = new HashTable(size);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the keywords
     */
    public HashTable getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(HashTable keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the next
     */
}
