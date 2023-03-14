/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class List {
    private Node pFirst;
    private Node pLast;
    private int size;

    public List() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    //Method to empty my list
    public void empty(){
       this.pFirst = null; 
       this.pLast = null;
       this.size = 0;
        
    }
    
    
    
    //Method to check if my list is empty
    public boolean isEmpty(){
        return getpFirst() == null;
    }
    
      //Append to list from the back
     public void addEnd(Object data){ 
        Node nuevo = new Node (data);
        if (this.isEmpty()){
            this.pFirst= nuevo;
            this.pLast= nuevo;
        }else{
            this.getpLast().setpNext(nuevo);
            this.pLast = nuevo;
        }this.size+=1;
    }
     
       //Method to add at the start of my list
    public void addAtTheStart (Object data){
        Node nuevo = new Node(data);
        nuevo.setData(data);
        
        if (isEmpty()){
            this.pFirst = nuevo;
        }else{
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;
        }this.size += 1;
    }
    
      //Method to delete element at the start of the list 
     public void deleteatTheStart(){
         if(!isEmpty()){
             Node aux = getpFirst();
             setpFirst(aux.getpNext());
             aux.setpNext(null);
             this.setSize(this.getSize()-1);
         }
     }
     
    //Method to print my list
    public void printlist(){
    if (!isEmpty()){
        Node aux = getpFirst();
            for(int i = 0; i < getSize(); i++){
                System.out.println(aux.getData()+ " ");
                aux = aux.getpNext();
        }
    }else{
        System.out.println("The list is empty");
        }
    }
    
       // Method to search my list
    public boolean search (Object reference){
        Node aux = pFirst;
        boolean found = false;
        
        while (aux != null && found != true){
            if (reference == aux.getData()){
                found = true;
                System.out.println("Found");
                break;
            }
            else{
                aux = aux.getpNext();
            }
        }
        return found;
        
    }

    /**
     * @return the pFirst
     */
    public Node getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Node getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Node pLast) {
        this.pLast = pLast;
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
