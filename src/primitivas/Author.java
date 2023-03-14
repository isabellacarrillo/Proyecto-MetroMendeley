/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class Author {
    private String name;
    private Summary summaries;
    private Node next;

    public Author(String name, Summary summaries) {
        this.name = name;
        this.summaries = summaries;
        this.next = null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the summaries
     */
    public Summary getSummaries() {
        return summaries;
    }

    /**
     * @param summaries the summaries to set
     */
    public void setSummaries(Summary summaries) {
        this.summaries = summaries;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    
    
}
