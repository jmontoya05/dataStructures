package linkedList.linkedListStructure;

import java.util.NoSuchElementException;

public class LinkedList {
    protected Node head = null;
    protected Node tail = null;


    public void addToStart(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void addToTheEnd(int value) {
        if (tail == null) {
            addToStart(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addByPosition(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Indice no valido (negativo)");
        } else if (index == 0) {
            addToStart(value);
        } else if (isEmpty()) {
            throw new IndexOutOfBoundsException("La lista está vacía, solo se puede agregar en el indice 0");
        } else {
            Node newNode = new Node(value);
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
                if (currentNode == null) {
                    throw new IndexOutOfBoundsException("Indice fuera del rango actual de la lista");
                }
            }

            if (currentNode.next == null) {
                addToTheEnd(value);
            } else {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }
    }

    public int deleteAtStartup() {
        if (!isEmpty()) {
            int headErased = head.value;
            if (head.next == null) {
                tail = null;
            }
            head = head.next;
            return headErased;
        }
        throw new NoSuchElementException("La lista está vacía");
    }

    public int deleteAtTheEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista está vacía");
        } else if (head.next == null) {
            int tailErased = head.value;
            head = null;
            tail = null;
            return tailErased;
        } else {
            Node currentNode = head;
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            int tailErased = currentNode.next.value;
            currentNode.next = null;
            tail = currentNode;
            return tailErased;
        }
    }

    public String deleteNode(int value) {
        if (isEmpty()) {
            return "La lista está vacia";
        } else {
            int index = 0;
            if (head.value == value) {
                deleteAtStartup();
                return "Valor eliminado en la posición " + index;
            }
            Node currentNode = head;
            while (currentNode.next != null) {
                index++;
                if (currentNode.next.value == value) {
                    Node nodeErased = currentNode.next;
                    if (nodeErased.next == null) {
                        deleteAtTheEnd();
                    } else {
                        currentNode.next = currentNode.next.next;
                        nodeErased.next = null;
                    }
                    return "Valor eliminado en la posición " + index;
                }
                currentNode = currentNode.next;
            }
            return "No se encontró el valor " + value + " en la lista";
        }
    }

    public String deleteByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Indice no valido (negativo)");
        }
        if (isEmpty()) {
            return "No se puede eliminar, la lista está vacia";
        }
        if (index == 0) {
            return "Se ha eliminado el valor " + deleteAtStartup() + " de la posición " + index;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            if (currentNode.next == null) {
                return "Indice fuera del rango actual de la lista";
            }
            currentNode = currentNode.next;
        }
        if (currentNode.next.next == null) {
            return "Se ha eliminado el valor " + deleteAtTheEnd() + " de la posición " + index;
        }

        Node nodeErased = currentNode.next;
        currentNode.next = currentNode.next.next;
        nodeErased.next = null;
        return "Se ha eliminado el valor " + nodeErased.value + " de la posición " + index;

    }

    public String searchByValue(int value) {
        if (isEmpty()) {
            return "La lista está vacia";
        } else {
            int index = 0;
            if (head.value == value) {
                return "Valor encontrado en la posición " + index;
            }
            Node currentNode = head;
            while (currentNode.next != null) {
                index++;
                if (currentNode.next.value == value) {
                    return "Valor encontrado en la posición " + index;
                }
                currentNode = currentNode.next;
            }
            return "No se encontró el valor " + value + " en la lista";
        }
    }

    public String searchByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Indice no valido (negativo)");
        }
        if (isEmpty()) {
            return "La lista está vacia";
        }
        if (index == 0) {
            return "Se ha encontrado el valor " + head.value + " en la posición " + index;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode.next == null) {
                return "Indice fuera del rango actual de la lista";
            }
        }
        return "Se ha encontrado el valor " + currentNode.next.value + " en la posición " + index;
    }

    public int getFirstValue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }
        return head.value;
    }

    public int getLastValue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("La lista está vacía");
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        Node currentNode = head;
        int size = 1;
        while (currentNode.next != null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void showAllValues(){
        if (isEmpty()) {
            System.out.println("La lista está vacía");;
        }
        Node currentNode = head;
        while (currentNode != null){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
