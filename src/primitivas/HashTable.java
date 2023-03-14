/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class HashTable {
    private Node array[];
    private int size;

    public HashTable(Node[] array, int size) {
        this.array = array;
        this.size = size;
    }

    /**
     * @return the array
     */
    public Node[] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(Node[] array) {
        this.array = array;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
}
