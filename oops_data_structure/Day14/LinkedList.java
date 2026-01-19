
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

    public void insertAfter(T key, T data) {
        Node<T> temp = head;
        while (temp != null && !temp.data.equals(key))
            temp = temp.next;

        if (temp != null) {
            Node<T> node = new Node<>(data);
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data );
            if(temp.next != null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(56);
        list.append(70);
        list.insertAfter(56, 30);
        list.print();
    }
}
