/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

import application.Global;

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

    public List(Node pNew) {
        this.pFirst = pNew;
        this.pLast = pNew;
        this.size = 1;
    }

    //Method to empty my list
    public void empty() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;

    }

    //Method to check if my list is empty
    public boolean isEmpty() {
        return getpFirst() == null;
    }

    //Append to list from the back
    public void addEnd(Node data) {
        if (this.isEmpty()) {
            this.pFirst = data;
            this.pLast = data;
        } else {
            this.getpLast().setpNext(data);
            this.setpLast(data);
        }
        this.setSize(this.getSize()+1);
    }

    //Method to add at the start of my list
    public void addAtTheStart(Node data) {
        if (isEmpty()) {
            this.setpFirst(data);
        } else {
            data.setpNext(this.getpFirst());
            this.setpFirst(data);
        }
        this.setSize(this.getSize() + 1);
    }

    //Method to delete element at the start of the list 
    public void deleteatTheStart() {
        if (!isEmpty()) {
            Node aux = getpFirst();
            setpFirst(aux.getpNext());
            aux.setpNext(null);
            this.setSize(this.getSize() - 1);
        }
    }

    //Method to print my list
    public void printlist() {
        if (!isEmpty()) {
            Node aux = getpFirst();
            for (int i = 0; i < getSize(); i++) {
                System.out.println(aux.getData() + " ");
                aux = aux.getpNext();
            }
        } else {
            System.out.println("The list is empty");
        }
    }

    // Method to search my list
    public boolean search(Object reference) {
        Node aux = pFirst;
        boolean found = false;

        while (aux != null && found != true) {
            if (reference == aux.getData()) {
                found = true;
                System.out.println("Found");
                break;
            } else {
                aux = aux.getpNext();
            }
        }
        return found;

    }

    //Pocedimiento para agregar los elemtnos al display
    public void addToListInAlphabeticalOrder(Summary resumen) {
        SummaryTitle New = new SummaryTitle(resumen.getTitle());
        Node<SummaryTitle> pNew = new Node(New);
        boolean esta = false;
        if (this.isEmpty()) {
            this.setpFirst(pNew);
            this.setpLast(pNew);
            this.setSize(this.getSize() + 1);
        } else {
            Node<SummaryTitle> pAux = this.getpFirst();

            for (int i = 0; i < this.getSize(); i++) {
                String oldAuthor = pAux.getData().getTitle();
                if (pAux.equals(this.getpFirst())) {
                    if ((pNew.getData().getTitle()).compareToIgnoreCase(pAux.getData().getTitle()) < 0) {
                        this.addAtTheStart(pNew);
                        break;
                    } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0)) {
                        esta = true;
                        break;

                    }
                }
                if ((pAux.equals(this.getpLast()))) {
                    if (pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) > 0) {
                        this.addEnd(pNew);
                        break;
                    } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0)) {
                        esta = true;
                        break;
                    }

                } else {
                    if (pNew.getData().getTitle().compareToIgnoreCase(pAux.getpNext().getData().getTitle()) < 0) {
                        pNew.setpNext(pAux.getpNext());
                        pAux.setpNext(pNew);
                        this.setSize(this.getSize() + 1);
                        break;
                    } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0)) {
                        esta = true;
                        break;
                    }

                }

                pAux = pAux.getpNext();
            }
        }

    }

//Procedimiento que agrega autores al Global
    public void agregarAutorAlDisplay(String nombre) {
        Author newAuthor = new Author(nombre);
        Node<Author> pNew = new Node(newAuthor);
        boolean esta = false;
        Node<Author> pAux = this.getpFirst();
        if (this.isEmpty()) {
            this.setpFirst(pNew);
            this.setpLast(pNew);
            this.setSize(1);
            esta = true;
        } else {
            for (int i = 0; i < this.getSize(); i++) {
                if ((pAux.getData().getName()).equalsIgnoreCase(nombre)) {
                    esta = true;
                    break;
                }
                pAux = pAux.getpNext();
            }
        }
        if (!esta) {
            this.addEnd(pNew);
        }
    }

    public void addSummariesToArray(Summary resumen) {
        boolean esta = false;
        if (!this.isEmpty()) {
            Node<Summary> pAux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                if ((pAux.getData().getTitle().equalsIgnoreCase(resumen.getTitle())) && pAux.getData().getAuthors().equalsIgnoreCase(resumen.getAuthors())) {
                    esta = true;
                    resumen.setRepeated(true);
                }
            }
        }
        if (!esta) {
            Node<Summary> pNew = new Node<>(resumen);
            this.addEnd(pNew);
        }

    }

    public void addAuthorToArray(String name, String summary) {
        boolean esta = false;
        if (!this.isEmpty()) {
            Node<Author> pAux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                if (pAux.getData().getName().equalsIgnoreCase(name)) {
                    esta = true;
                    pAux.getData().getSummaries().addSummaryToHash(summary);
                    break;
                }
            }

        }
        if (!esta) {
            SummaryTitle sum = new SummaryTitle(summary);
            Node<SummaryTitle> pSum = new Node(sum);
            Author author = new Author(name);
            if (author.getSummaries() == null) {
                List lAux = new List();
                author.setSummaries(lAux);
            }
            author.getSummaries().addEnd(pSum);
            Node<Author> pAutor = new Node<>(author);
            this.addEnd(pAutor);
        }
    }

    public void addToKeyWordsHash(String palabra, String resumen) {
        boolean esta = false;
        if (!this.isEmpty()) {
            Node<KeyWords> pAux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                if (pAux.getData().getWord().equalsIgnoreCase(palabra)) {
                    esta = true;
                    pAux.getData().getSummary().addSummaryToHash(resumen);
                    break;
                }
            }

        }
        if (!esta) {
            SummaryTitle sum = new SummaryTitle(resumen);
            Node<SummaryTitle> pSum = new Node(sum);
            KeyWords kw = new KeyWords(palabra);
            if (kw.getSummary() == null) {
                List lAux = new List();
                kw.setSummary(lAux);
            }
            kw.getSummary().addEnd(pSum);
            Node<KeyWords> pKW = new Node<>(kw);
            this.addEnd(pKW);
        }
    }

    public void addSummaryToHash(String summary) {
        boolean esta = false;
        if (!this.isEmpty()) {
            Node<SummaryTitle> pAux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                if (pAux.getData().getTitle().equalsIgnoreCase(summary)) {
                    esta = true;
                    break;
                }
            }
        }
        if (!esta) {
            SummaryTitle sum = new SummaryTitle(summary);
            Node<SummaryTitle> pSum = new Node<>(sum);
            this.addEnd(pSum);
        }
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
