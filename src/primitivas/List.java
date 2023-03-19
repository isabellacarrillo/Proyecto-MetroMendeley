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
        Node nuevo = new Node(data);
        if (this.isEmpty()) {
            this.pFirst = nuevo;
            this.pLast = nuevo;
        } else {
            this.getpLast().setpNext(nuevo);
            this.pLast = nuevo;
        }
        this.size += 1;
    }

    //Method to add at the start of my list
    public void addAtTheStart(Node data) {
        Node nuevo = new Node(data);
        nuevo.setData(data);

        if (isEmpty()) {
            this.pFirst = nuevo;
        } else {
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;
        }
        this.size += 1;
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

    //Pocedimiento para colisiones en el hashtable de resumenes
    public void addToListInAlphabeticalOrder(Summary resumen) {
        Node<Summary> pNew = new Node(resumen);
        boolean esta = false;
        if (this.isEmpty()) {
            this.setpFirst(pNew);
            this.setpLast(pNew);
        } else {
            Node<Summary> pAux = this.getpFirst();

            for (int i = 0; i < this.getSize(); i++) {
                if (pAux == pFirst) {
                    if (pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) < 0) {
                        this.addAtTheStart(pNew);
                        break;
                    } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0) && (pNew.getData().getAuthors().equalsIgnoreCase(pAux.getData().getAuthors()))) {
                        esta = true;
                        break;
                    }
                }
                if ((pAux == pLast)) {
                    if (pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) > 0) {
                        this.addEnd(pNew);
                        break;
                    } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0) && (pNew.getData().getAuthors().equalsIgnoreCase(pAux.getData().getAuthors()))) {
                        esta = true;
                        break;

                    } else {
                        if (pNew.getData().getTitle().compareToIgnoreCase(pAux.getpNext().getData().getTitle()) < 0) {
                            pNew.setpNext(pAux.getpNext());
                            pAux.setpNext(pNew);
                            break;
                        } else if ((pNew.getData().getTitle().compareToIgnoreCase(pAux.getData().getTitle()) == 0) && (pNew.getData().getAuthors().equalsIgnoreCase(pAux.getData().getAuthors()))) {
                            esta = true;
                            break;
                        }
                    }
                    pAux = pAux.getpNext();
                }
            }
        }
        if (!esta) {
            this.setSize(this.getSize() + 1);
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
            author.getSummaries().addEnd(pSum);
            Node<Author> pAutor = new Node<>(author);
            this.addEnd(pAutor);
            this.setSize(this.getSize() + 1);
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
            kw.getSummary().addEnd(pSum);
            Node<KeyWords> pKW = new Node<>(kw);
            this.addEnd(pKW);
            this.setSize(this.getSize() + 1);
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
            this.setSize(this.getSize() + 1);
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
