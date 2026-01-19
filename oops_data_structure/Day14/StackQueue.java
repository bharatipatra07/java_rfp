class LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    public void append(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print( " -> ");
            }
            temp = temp.next;
        }
    }
}
class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T data) {
        list.append(data);
    }

    public void display() {
        list.display();
    }
}

public class StackQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        // Expected: 56 -> 30 -> 70
        queue.display();
    }
}
