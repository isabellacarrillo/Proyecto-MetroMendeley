/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class KeyWords {
    private String word;
    private List summary;

    public KeyWords(String word, List summary) {
        this.word = word;
        this.summary = summary;
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the summary
     */
    public List getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(List summary) {
        this.summary = summary;
    }
    
    
}
