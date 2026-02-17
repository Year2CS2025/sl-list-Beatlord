package SLIST;


import java.util.NoSuchElementException;

public class SLinkedList<T> {
    class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
            next=null;
        }

    }

    private Node<T> head;
    private Node<T> tail;
    private int size=0;
    public SLinkedList(){
        head=null;
        size=0;

}
    
   
               
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        if (head == null) {
            tail = newNode; // Only update tail if it's the very first element
            }
        head = newNode;
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail=newNode;
        } else {
            tail.next = newNode;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public T deleteFirst(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // If the list becomes empty, set tail to null
        }
        return data;
    }
    public T deleteLast(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.next == null) { // Only one element
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T data = tail.data;
        current.next = null;
        tail = current;
        size--;
        return data;
    }
    public void display(){
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public boolean contains(T data){
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void clear(){
        head = null;
        tail=null;
        size=0;
    }
    public T getFirst(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }
    public T getLast(){
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }
    public void remove (T e) {
        //removes first occurrence of e
    }
    public void reverse(){
        if (head == null || head.next == null) return;
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> nextNode = null;
        // Update tail to be the current head
        tail = head;
        while (current != null) {
            nextNode = current.next; // Store the next node
            current.next = prev;     // Flip the pointer backward
            prev = current;          // Move prev forward
            current = nextNode;      // Move current forward
            }
        head = prev; // The last 'prev' becomes the new head        
   
    }
    public void deleteConsecutiveDuplicates(){
        if (head == null) return;
        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(current.next.data)) {
                // Skip the next node
                current.next = current.next.next;
                size--;
                // Update tail if we just deleted the end
                if (current.next == null) {
                    tail = current;
            }} else {
                current = current.next; // Only move forward if no deletion
        }
    }
    }

    //two lists are equal if they have the same 
    // size and the same elements in the same order
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof SLinkedList)) return false;

        SLinkedList<T> other = (SLinkedList<T>) obj;
        if (this.size != other.size) return false;

        Node<T> currentThis = this.head;
        Node<T> currentOther = other.head;
        while (currentThis != null) {
            if (!currentThis.data.equals(currentOther.data)) {
                return false;
        }
            currentThis = currentThis.next;
            currentOther = currentOther.next;
    }
        return true;
    }

}
