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
    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }
    public T pop() {
        if (head == null)
            return null;

        T data = head.data;
        head = head.next;
        return data;
    }

    public T peek() {
        return head == null ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
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

    public T pop() {
        return list.pop();
    }

    public T peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void display(){
        list.display();
    }
}

public class StackQueue {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(70);
        stack.push(30);
        stack.push(56);
        stack.display();
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.println("Peek: " + stack.peek());
            System.out.println("Pop: " + stack.pop());
        }
    }
}
