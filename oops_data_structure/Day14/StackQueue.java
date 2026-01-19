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

    // Add at beginning (Stack push)
    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
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
//uc1
class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T data) {
        list.add(data);
    }

    public void display() {
        list.display();
    }
}

public class StackQueue {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(70);
        stack.push(30);
        stack.push(56);

        // Expected: 56 -> 30 -> 70
        stack.display();
    }
}
