
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList<T extends Comparable<T>> {

    Node<T> head;

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null || data.compareTo(head.data) < 0) {
            node.next = head;
            head = node;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && data.compareTo(temp.next.data) > 0)
            temp = temp.next;

        node.next = temp.next;
        temp.next = node;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print( " -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(56);
        list.add(30);
        list.add(40);
        list.add(70);

        list.print();
    }
}

