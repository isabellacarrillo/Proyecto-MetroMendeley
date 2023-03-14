/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class KeyWordsHash {
    private Node keywordsarray[];
    private Node first;

    public KeyWordsHash() {
        this.keywordsarray = null;
        this.first = null;
    }

    /**
     * @return the keywordsarray
     */
    public Node[] getKeywordsarray() {
        return keywordsarray;
    }

    /**
     * @param keywordsarray the keywordsarray to set
     */
    public void setKeywordsarray(Node[] keywordsarray) {
        this.keywordsarray = keywordsarray;
    }

    /**
     * @return the first
     */
    public Node getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Node first) {
        this.first = first;
    }
    
    
}
