package Linear.linkedlists;

// import java.util.LinkedList;

// import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new linkedList();
        // System.out.println(list.size());
        list.addLast(10);
        list.addLast(1);
        list.addLast(2);
        list.addFirst(77);
        list.addFirst(22);
        list.addFirst(55);
        // list.printMiddle();
        // System.out.println(list.getKthFromEnd(-1));
        // list.reversed();
        // System.out.println(list.size());
        // list.deleteLast();
        // list.deleteFirst();
        // System.out.println(list.size());
        // System.out.println(list.indexOf(10));
        // System.out.println(list.contains(77));
        // var array = list.toArray();
        // System.out.println(Arrays.toString(array));
        list.printList();

        // list = list.createWithLoop();
        // System.out.println(list.hasLoop());
    }
}
