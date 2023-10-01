package linkedList.linkedListStructure;

public class Node {
    int value;
    Node next = null;

    Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
