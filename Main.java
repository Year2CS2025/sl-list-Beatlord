package SLIST;

public class Main {
    public static void main(String[] args) {
        SLinkedList<Integer> list = new SLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(5);
        for (Integer i : list) {
            System.out.println(i);
        }
        SLinkedList<Integer> l2=new SLinkedList<>();
        l2.addFirst(10);
        l2.addFirst(20);
        l2.addLast(5);
 
        if (list.equals(l2))
            System.out.println("Hoorah");
        else
            System.out.println("Not equal");
        
        // Testing Reverse
        System.out.println("Original list:");
        list.display();
        list.reverse();
        System.out.println("Reversed list:");
        list.display();

        // Testing Remove
        list.remove(10);
        System.out.println("After removing 10:");
        list.display();
        
        // Testing Duplicates
        list.addLast(5); // Now we have two 5s at the end
        System.out.println("Before removing duplicates:");
        list.display();
        list.deleteConsecutiveDuplicates();
        System.out.println("After removing consecutive duplicates:");
        list.display();
    }
    
}
