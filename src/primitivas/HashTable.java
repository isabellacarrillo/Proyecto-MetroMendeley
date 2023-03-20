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
    private List array[];
    private int size;

    public HashTable(int size) {
        
        this.array = new List[size];
        this.size = size;
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

    /**
     * @return the array
     */
    public List[] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(List[] array) {
        this.array = array;
    }
    
    
    
    
}
