/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class AuthorHash {
    private Node authorsarray[];
    private Node first;

    public AuthorHash() {
        this.authorsarray = null;
        this.first = null;
    }

    /**
     * @return the authorsarray
     */
    public Node[] getAuthorsarray() {
        return authorsarray;
    }

    /**
     * @param authorsarray the authorsarray to set
     */
    public void setAuthorsarray(Node[] authorsarray) {
        this.authorsarray = authorsarray;
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
