package arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        // Array newnumbers = new Array(3);
        numbers.insert(70);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        // newnumbers.insert(20);
        // newnumbers.insert(40);
        // newnumbers.insert(70);
        // numbers.removeAt(1);
        // Array.insertAt()
        // System.out.println(numbers.indexOf(40));
        // numbers.intersect(newnumbers);
        // numbers.reverse();
        numbers.insertAt(1, 1);
        numbers.print();

    }
}
