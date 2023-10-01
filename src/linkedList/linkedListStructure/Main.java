package linkedList.linkedListStructure;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        System.out.println("El tamaño de la lista es " + linkedList.size());
        linkedList.addToStart(2);
        linkedList.addToTheEnd(3);
        linkedList.addToStart(5);
        linkedList.addByPosition(1,6);
        linkedList.addByPosition(1,8);
        System.out.println("El tamaño de la lista es " + linkedList.size());
        linkedList.addByPosition(1,10);
        System.out.println(linkedList.searchByIndex(5));
        linkedList.showAllValues();
        System.out.println(linkedList.deleteAtStartup());
        System.out.println(linkedList.deleteAtTheEnd());
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.deleteNode(6));
        System.out.println(linkedList.deleteByIndex(2));
        System.out.println(linkedList.searchByValue(10));
        System.out.println(linkedList.searchByIndex(1));
        System.out.println(linkedList.getFirstValue());
        System.out.println(linkedList.getLastValue());
        System.out.println("El tamaño de la lista es " + linkedList.size());
        linkedList.showAllValues();

    }
}
