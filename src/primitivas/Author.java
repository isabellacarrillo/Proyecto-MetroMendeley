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
    private List summaries;
    private String name;

    public Author(List summaries, String name) {
        this.summaries = summaries;
        this.name = name;
    }

    /**
     * @return the summaries
     */
    public List getSummaries() {
        return summaries;
    }

    /**
     * @param summaries the summaries to set
     */
    public void setSummaries(List summaries) {
        this.summaries = summaries;
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
    
    
}
