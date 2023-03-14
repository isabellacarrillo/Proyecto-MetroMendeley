/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class Node <T>{
    private T data;
    private Node <T> pNext;

/**
 *
 * Constructors for the generic node 
 */    
    public Node() {
        this.data = null;
        this.pNext = null;
    }

    public Node(T elem) {
        this.data = elem;
        this.pNext = null;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Node <T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Node <T> pNext) {
        this.pNext = pNext;
    }
    
    
}
