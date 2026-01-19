
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList<T> {

    Node<T> head;

    public void append(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node<>(data);
    }

    public void pop() {
        if (head != null)
            head = head.next;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.next!=null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(56);
        list.append(30);
        list.append(70);
        list.print();
        list.pop();
        System.out.println();
        list.print();
    }
}